package com.khater.donut.ui.screens.onBoardingScreen

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import com.khater.donut.ui.navigation.OnBoardingScreen

fun EntryProviderBuilder<*>.onBoardingScreenRoute(backStack: NavBackStack) {
    entry<OnBoardingScreen> {
        OnBoardingScreen(backStack)
    }
}