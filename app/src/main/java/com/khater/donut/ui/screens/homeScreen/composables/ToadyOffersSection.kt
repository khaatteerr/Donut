package com.khater.donut.ui.screens.homeScreen.composables

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import com.khater.donut.R
import com.khater.donut.ui.navigation.DonutDetailScreen
import com.khater.donut.ui.screens.homeScreen.uiStates.TodayOfferUiState

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ToadyOffersSection(
    modifier: Modifier = Modifier,
    backStack: NavBackStack,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    val todayDonuts = remember {

        listOf(
            TodayOfferUiState(
                id = "donut_1",
                isFavorite = false,
                isDiscounted = true,
                image = R.drawable.l_donut_1,
                title = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                backgroundColor = Color(0xFFD7E4F6),
                oldPrice = 20,
                newPrice = 16
            ),
            TodayOfferUiState(
                id = "donut_2",
                isFavorite = false,
                isDiscounted = true,
                image = R.drawable.l_donut_2,
                title = "Chocolate Glaze",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                backgroundColor = Color(0xFFFFC7D0),
                oldPrice = 20,
                newPrice = 16
            ),
            TodayOfferUiState(
                id = "donut_3",
                isFavorite = false,
                isDiscounted = true,
                image = R.drawable.l_donut_1,
                title = "Strawberry Wheel",
                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
                backgroundColor = Color(0xFFF6D7F1),
                oldPrice = 20,
                newPrice = 16
            ),
            TodayOfferUiState(
                id = "donut_4",
                isFavorite = false,
                isDiscounted = true,
                image = R.drawable.l_donut_2,
                title = "Chocolate Glaze",
                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                backgroundColor = Color(0xFFEEC7FF),
                oldPrice = 20,
                newPrice = 16
            ),
        )
    }
    Spacer(Modifier.height(54.dp))
    Column(modifier.fillMaxSize()) {


        SectionLabel("Today Offers")
        val lazyRowState = rememberLazyListState()

        LazyRow(
            state = lazyRowState,
            modifier =  Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(48.dp),
            contentPadding = PaddingValues(top = 25.dp, start = 20.dp, bottom = 46.dp, end = 30.dp)
        ) {
            items(todayDonuts, key = { it.id }) { todayDonut ->
                TodayOfferItem(
                    todayOfferUiState = todayDonut,
                    onItemClicked = {
                        backStack.add(DonutDetailScreen.fromTodayOfferUiState(todayDonut))
                    },
                    sharedTransitionScope = sharedTransitionScope,
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
        }
    }
//    Spacer(Modifier.height(54.dp))
//    Column(modifier.fillMaxSize()) {
//
//        val todayDonuts = listOf(
//            TodayOfferUiState(
//                isFavorite = false,
//                isDiscounted = true,
//                image = R.drawable.l_donut_1,
//                title = "Strawberry Wheel",
//                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
//                backgroundColor = Color(0xFFD7E4F6),
//                oldPrice = 20,
//                newPrice = 16
//
//            ),
//            TodayOfferUiState(
//                isFavorite = false,
//                isDiscounted = true,
//                image = R.drawable.l_donut_2,
//                title = "Chocolate Glaze",
//                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
//                backgroundColor = Color(0xFFFFC7D0),
//                oldPrice = 20,
//                newPrice = 16
//            ),
//            TodayOfferUiState(
//                isFavorite = false,
//                isDiscounted = true,
//                image = R.drawable.l_donut_1,
//                title = "Strawberry Wheel",
//                description = "These Baked Strawberry Donuts are filled with fresh strawberries...",
//                backgroundColor = Color(0xFFF6D7F1),
//                oldPrice = 20,
//                newPrice = 16
//
//            ),
//            TodayOfferUiState(
//                isFavorite = false,
//                isDiscounted = true,
//                image = R.drawable.l_donut_2,
//                title = "Chocolate Glaze",
//                description = "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
//                backgroundColor = Color(0xFFEEC7FF),
//                oldPrice = 20,
//                newPrice = 16
//            ),
//
//            )
//
//        SectionLabel("Today Offers")
//
//        LazyRow(
//            Modifier.fillMaxSize(),
//            horizontalArrangement = Arrangement.spacedBy(48.dp),
//            contentPadding = PaddingValues(top = 25.dp, start = 20.dp, bottom = 46.dp, end = 30.dp)
//        ) {
//            items(todayDonuts) { todayDonut ->
//                TodayOfferItem(
//                    todayDonut,
//                    onItemClicked = { backStack.add(DonutDetailScreen) }
//                )
//            }
//        }
//    }

}