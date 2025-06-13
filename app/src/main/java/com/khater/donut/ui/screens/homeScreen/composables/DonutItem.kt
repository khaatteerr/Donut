package com.khater.donut.ui.screens.homeScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.khater.donut.ui.screens.homeScreen.uiStates.DonutUiState
import com.khater.donut.ui.theme.Inter
import com.khater.donut.ui.utils.dropShadow.dropShadow

@Composable
fun DonutItem(donutUiState: DonutUiState) {

    Box(
        modifier = Modifier
            .height(151.dp)
            .width(138.dp),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(donutUiState.image),
            contentDescription = "Donut Image",
            modifier = Modifier
                .size(80.dp)
                .offset(y = (-10).dp)
                .zIndex(1f)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier

                .align(Alignment.BottomCenter)
                .height(111.dp)
                .width(138.dp)

                .dropShadow(
                    color = Color.Black.copy(0.1f),
                    shape = RoundedCornerShape(
                        topEnd = 20.dp,
                        topStart = 20.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                )
                .background(
                    Color.White, RoundedCornerShape(
                        topEnd = 20.dp,
                        topStart = 20.dp,
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                ),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier.padding(top = 47.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    donutUiState.title,
                    fontFamily = Inter,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black.copy(0.6f)
                )
                Text(
                    "$${donutUiState.price}",
                    fontFamily = Inter,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFFF7074)
                )
            }
        }
    }
}