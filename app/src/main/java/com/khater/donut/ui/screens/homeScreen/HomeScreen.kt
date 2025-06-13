package com.khater.donut.ui.screens.homeScreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import com.khater.donut.ui.screens.donutsDetailsScreen.DonutDetailScreen
import com.khater.donut.ui.screens.homeScreen.composables.DonutsSection
import com.khater.donut.ui.screens.homeScreen.composables.HeaderSection
import com.khater.donut.ui.screens.homeScreen.composables.ToadyOffersSection

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(backStack: NavBackStack,
               sharedTransitionScope: SharedTransitionScope,
               animatedVisibilityScope: AnimatedVisibilityScope) {

    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()

            .background(Color.White)
            .verticalScroll(scrollState)
            .padding(bottom = 60.dp)
    ) {
        HeaderSection()
        ToadyOffersSection(
            backStack = backStack,
            sharedTransitionScope = sharedTransitionScope,
            animatedVisibilityScope = animatedVisibilityScope
        )
        DonutsSection()
    }
}





