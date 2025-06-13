package com.khater.donut.ui.utils.parallerEffect

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

/**
 * Applies parallax effect to a composable using device sensors
 *
 * @param depthMultiplier Multiplier for the parallax effect intensity
 * @param enableOffset Whether to apply offset transformation
 * @param enableAlignment Whether to apply alignment transformation
 * @param alignmentBias Bias multiplier for alignment effect (default 0.005f)
 */
@SuppressLint("UnrememberedMutableState")
fun Modifier.parallax(
    depthMultiplier: Int = 20,
    enableOffset: Boolean = true,
    enableAlignment: Boolean = false,
    alignmentBias: Float = 0.005f
): Modifier = composed {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var sensorData by remember { mutableStateOf<SensorData?>(null) }

    // Initialize sensor data manager
    DisposableEffect(Unit) {
        val dataManager = SensorDataManager(context)
        dataManager.init()

        val job = scope.launch {
            dataManager.data
                .receiveAsFlow()
                .onEach { sensorData = it }
                .collect()
        }

        onDispose {
            dataManager.cancel()
            job.cancel()
        }
    }

    val roll by derivedStateOf { (sensorData?.roll ?: 0f) * depthMultiplier }
    val pitch by derivedStateOf { (sensorData?.pitch ?: 0f) * depthMultiplier }

    var modifier = this

    // Apply offset transformation if enabled
    if (enableOffset) {
        modifier = modifier.offset {
            IntOffset(
                x = roll.dp.roundToPx(),
                y = -pitch.dp.roundToPx()
            )
        }
    }

    // Apply alignment transformation if enabled
    if (enableAlignment) {
        modifier = modifier.layout { measurable, constraints ->
            val placeable = measurable.measure(constraints)

            layout(placeable.width, placeable.height) {
                val horizontalBias = (roll * alignmentBias).coerceIn(-1f, 1f)
                val verticalBias = 0f

                val x = ((constraints.maxWidth - placeable.width) * (horizontalBias + 1) / 2).roundToInt()
                val y = ((constraints.maxHeight - placeable.height) * (verticalBias + 1) / 2).roundToInt()

                placeable.place(x, y)
            }
        }
    }

    modifier
}

/**
 * Simplified parallax modifier for basic offset-only effects
 */
fun Modifier.parallaxOffset(
    depthMultiplier: Int = 20
): Modifier = parallax(
    depthMultiplier = depthMultiplier,
    enableOffset = true,
    enableAlignment = false
)

/**
 * Parallax modifier with both offset and alignment effects
 */
fun Modifier.parallaxWithAlignment(
    depthMultiplier: Int = 20,
    alignmentBias: Float = 0.005f
): Modifier = parallax(
    depthMultiplier = depthMultiplier,
    enableOffset = true,
    enableAlignment = true,
    alignmentBias = alignmentBias
)

/**
 * Creates a parallax container that manages sensor data for child composables
 * Use this when you have multiple elements that need parallax and want to share sensor data
 */
@Composable
fun ParallaxContainer(
    modifier: Modifier = Modifier,
    content: @Composable (SensorData?) -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var sensorData by remember { mutableStateOf<SensorData?>(null) }

    DisposableEffect(Unit) {
        val dataManager = SensorDataManager(context)
        dataManager.init()

        val job = scope.launch {
            dataManager.data
                .receiveAsFlow()
                .onEach { sensorData = it }
                .collect()
        }

        onDispose {
            dataManager.cancel()
            job.cancel()
        }
    }

    Box(modifier = modifier) {
        content(sensorData)
    }
}