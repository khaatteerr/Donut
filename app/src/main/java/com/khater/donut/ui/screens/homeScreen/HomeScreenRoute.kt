package com.khater.donut.ui.screens.homeScreen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import com.khater.donut.ui.navigation.HomeScreen

@OptIn(ExperimentalSharedTransitionApi::class)
fun EntryProviderBuilder<*>.homeScreenRoute(backStack: NavBackStack,
                                            sharedTransitionScope: SharedTransitionScope,
                                            animatedVisibilityScope: AnimatedVisibilityScope) {
    entry<HomeScreen> {
        HomeScreen(backStack,sharedTransitionScope,animatedVisibilityScope)
    }
}