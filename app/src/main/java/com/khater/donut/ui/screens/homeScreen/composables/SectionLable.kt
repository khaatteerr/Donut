package com.khater.donut.ui.screens.homeScreen.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khater.donut.ui.theme.Inter

@Composable
fun SectionLabel(text: String,modifier: Modifier = Modifier) {
    Text(
        text,
        modifier = modifier .padding(horizontal = 20.dp),
        fontFamily = Inter,
        fontSize = 20.sp,
        fontWeight = FontWeight .SemiBold,
        color = Color .Black
    )
}