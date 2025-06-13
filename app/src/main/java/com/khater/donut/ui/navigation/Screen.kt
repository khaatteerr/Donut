package com.khater.donut.ui.navigation

import androidx.compose.ui.graphics.Color
import androidx.navigation3.runtime.NavKey
import com.khater.donut.R
import com.khater.donut.ui.screens.homeScreen.uiStates.TodayOfferUiState
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen : NavKey, BottomNavItem {
    override val icon: Int = R.drawable.home
    override val fillIcon: Int = R.drawable.fill_home

}
@Serializable
data object FavoriteScreen : NavKey, BottomNavItem {
    override val icon: Int = R.drawable.heart
    override val fillIcon: Int = R.drawable.fill_heart
}

@Serializable
data object NotificationScreen : NavKey, BottomNavItem {
    override val icon: Int = R.drawable.notification
    override val fillIcon: Int = R.drawable.fill_notification
}

@Serializable
data object BuyScreen : NavKey, BottomNavItem {
    override val icon: Int = R.drawable.buy
    override val fillIcon: Int = R.drawable.fill_buy
}
@Serializable
data object ProfileScreen : NavKey, BottomNavItem {
    override val icon: Int = R.drawable.profile
    override val fillIcon: Int = R.drawable.fill_profile
}

@Serializable
data object OnBoardingScreen : NavKey

@Serializable
data class DonutDetailScreen(
    val donutId: String,
    val image: Int,
    val title: String,
    val description: String,
    val newPrice: Int,
    val backgroundColor: Long // Color as Long for serialization
) : NavKey {
    companion object {
        fun fromTodayOfferUiState(uiState: TodayOfferUiState): DonutDetailScreen {
            return DonutDetailScreen(
                donutId = uiState.id,
                image = uiState.image,
                title = uiState.title,
                description = uiState.description,
                newPrice = uiState.newPrice,
                backgroundColor = uiState.backgroundColor.value.toLong()
            )
        }
    }

    fun toTodayOfferUiState(): TodayOfferUiState {
        return TodayOfferUiState(
            id = donutId,
            isFavorite = false,
            isDiscounted = true,
            image = image,
            title = title,
            description = description,
            oldPrice = 20, // Default old price
            newPrice = newPrice,
            backgroundColor = Color(backgroundColor.toULong())
        )
    }
}

