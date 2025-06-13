package com.khater.donut.ui.screens.homeScreen.uiStates

import androidx.compose.ui.graphics.Color

data class TodayOfferUiState(
    val id: String,
    val isFavorite: Boolean = false,
    val isDiscounted: Boolean = false,
    val image: Int,
    val title: String,
    val description: String,
    val oldPrice: Int,
    val newPrice: Int,
    val backgroundColor: Color,
)
