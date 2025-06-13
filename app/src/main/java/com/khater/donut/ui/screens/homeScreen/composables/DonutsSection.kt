package com.khater.donut.ui.screens.homeScreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khater.donut.R
import com.khater.donut.ui.screens.homeScreen.uiStates.DonutUiState

@Composable
fun DonutsSection(modifier: Modifier = Modifier ) {

    SectionLabel("Donuts")

    val donuts = listOf(
        DonutUiState(
            image = R.drawable.donut1,
            title = "Chocolate Cherry",
            price = 22
        ),
        DonutUiState(
            image = R.drawable.donut2,
            title = "Strawberry Rain",
            price = 22
        ),
        DonutUiState(
            image = R.drawable.donut3,
            title = "Strawberry Coco",
            price = 22
        ),

        )
    LazyRow(
        Modifier .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(vertical = 35.dp, horizontal = 20.dp)
    ) {
        items(donuts) { donut ->
            DonutItem(donut)
        }
    }
}