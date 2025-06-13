package com.khater.donut.ui.screens.profileScreen

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import com.khater.donut.ui.navigation.OnBoardingScreen
import com.khater.donut.ui.navigation.ProfileScreen

fun EntryProviderBuilder<*>.profileScreenRoute(backStack: NavBackStack) {
    entry<ProfileScreen> {
        ProfileScreen(backStack)
    }
}