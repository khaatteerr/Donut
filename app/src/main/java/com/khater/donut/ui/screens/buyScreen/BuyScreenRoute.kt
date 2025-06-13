package com.khater.donut.ui.screens.buyScreen

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import com.khater.donut.ui.navigation.BuyScreen

fun EntryProviderBuilder<*>.buyScreenRoute(backStack: NavBackStack) {
    entry<BuyScreen> {
        BuyScreen(backStack)
    }
}