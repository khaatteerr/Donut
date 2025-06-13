package com.khater.donut.ui.screens.favoriteScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack

@Composable
fun FavoriteScreen(backStack: NavBackStack) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Favorite Screen")
    }
}