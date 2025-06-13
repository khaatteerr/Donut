package com.khater.donut.ui.screens.homeScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khater.donut.R
import com.khater.donut.ui.theme.Inter

@Composable
fun HeaderSection() {
    Spacer(Modifier.height(41.dp))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier, verticalArrangement = Arrangement.spacedBy(3.dp)) {

            Text(
                "Let’s Gonuts!",
                fontFamily = Inter,
                fontSize = 30.sp,
                color = Color(0xFFFF7074),
                fontWeight = SemiBold,
            )

            Text(
                "Order your favourite donuts from here",
                fontFamily = Inter,
                fontSize = 14.sp,
                color = Color.Black.copy(0.6f),
                fontWeight = Medium,
            )
        }

        Box(
            Modifier
                .size(45.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color(0xFFFED8DF)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = "Search Icon",
                tint = Color(0xFFFF7074)
            )
        }
    }
}