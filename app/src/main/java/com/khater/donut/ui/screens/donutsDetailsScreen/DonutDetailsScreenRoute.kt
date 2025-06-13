package com.khater.donut.ui.screens.donutsDetailsScreen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import com.khater.donut.ui.navigation.DonutDetailScreen

@OptIn(ExperimentalSharedTransitionApi::class)
fun EntryProviderBuilder<*>.donutDetailsScreenRoute(
    backStack: NavBackStack,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    entry<DonutDetailScreen> {
        DonutDetailScreen(backStack, it, sharedTransitionScope, animatedVisibilityScope)
    }
}