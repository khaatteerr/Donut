package com.khater.donut.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.khater.donut.ui.screens.buyScreen.buyScreenRoute
import com.khater.donut.ui.screens.donutsDetailsScreen.donutDetailsScreenRoute
import com.khater.donut.ui.screens.favoriteScreen.favoriteScreenRoute
import com.khater.donut.ui.screens.homeScreen.homeScreenRoute
import com.khater.donut.ui.screens.notificationScreen.notificationScreenRoute
import com.khater.donut.ui.screens.onBoardingScreen.onBoardingScreenRoute
import com.khater.donut.ui.screens.profileScreen.profileScreenRoute

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DonutNavGraph(
    backStack: NavBackStack,
    sharedTransitionScope: SharedTransitionScope
) {

    AnimatedContent(
        targetState = backStack.toList() ,
        transitionSpec = {
            fadeIn(animationSpec = tween(300)) togetherWith
                    fadeOut(animationSpec = tween(300))
        }
    ) { currentBackStack ->
        NavDisplay(
            backStack = currentBackStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSceneSetupNavEntryDecorator(),
                rememberSavedStateNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
             ),
            entryProvider = entryProvider {
                onBoardingScreenRoute(backStack)
                homeScreenRoute(backStack, sharedTransitionScope, this@AnimatedContent)
                donutDetailsScreenRoute(backStack, sharedTransitionScope, this@AnimatedContent)
                favoriteScreenRoute(backStack)
                notificationScreenRoute(backStack)
                buyScreenRoute(backStack)
                profileScreenRoute(backStack)
            }
        )
    }

}

