package com.khater.donut.ui.screens.favoriteScreen

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import com.khater.donut.ui.navigation.FavoriteScreen

fun EntryProviderBuilder<*>.favoriteScreenRoute(backStack: NavBackStack) {
    entry<FavoriteScreen> {
        FavoriteScreen(backStack)
    }
}