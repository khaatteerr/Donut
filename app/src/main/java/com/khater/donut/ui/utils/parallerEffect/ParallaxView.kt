package com.khater.donut.ui.utils.parallerEffect

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.khater.donut.R
import com.khater.donut.ui.screens.homeScreen.composables.doubleShadowDrop
import com.khater.donut.ui.utils.dropShadow.dropShadow

@Composable
fun ParallaxView(
    modifier: Modifier = Modifier,
    depthMultiplier: Int = 20
) {
    Box(modifier = modifier) {
         Image(
            painter = painterResource(id = R.drawable.donuts),
            modifier = Modifier
            //    .padding(top = 20.dp)
                .height(401.dp)
                .rotate(-5f)
                .scale(1.3f)
                .offset(x = 40.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
             contentDescription = null,
            contentScale = ContentScale.FillHeight,
        )

         Image(
            painter = painterResource(id = R.drawable.donut_1),
            modifier = Modifier
                .parallax(depthMultiplier = depthMultiplier)
                .size(130.dp)
                .offset(y = -20.dp)
                .align(Alignment.TopStart),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

         Image(
            painter = painterResource(id = R.drawable.donut_with_pink_icing),
            modifier = Modifier
                .parallax(depthMultiplier = depthMultiplier)
                .size(150.dp)
                .padding(end = 33.dp, top = 40.dp)
                .offset(y = -20.dp)
                .align(Alignment.TopEnd),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Image(
            painter = painterResource(id = R.drawable.donut_with_pink_icing),
            modifier = Modifier
                .parallax(depthMultiplier = depthMultiplier)
                .size(110.dp)
                .offset(y = -150.dp, x = 30.dp)
                .rotate(45f)
                .padding(start = 33.dp)
                .align(Alignment.BottomStart),
            contentDescription = null,
            contentScale = ContentScale.Inside,
        )

         Image(
            painter = painterResource(id = R.drawable.donut_2),
            modifier = Modifier
                .parallaxOffset(depthMultiplier = depthMultiplier)
                .offset(x = 50.dp, y = 20.dp)
                .size(130.dp)
                .align(Alignment.BottomEnd),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}
