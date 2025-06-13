package com.khater.donut.ui.screens.onBoardingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import com.khater.donut.ui.navigation.HomeScreen
import com.khater.donut.ui.theme.Inter
import com.khater.donut.ui.utils.parallerEffect.ParallaxView

@Composable
fun OnBoardingScreen(backStack: NavBackStack) {

    Column(
        Modifier
            .fillMaxSize()
         //   .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFED8DF))
    ) {

        Box {
            ParallaxView(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),

            )
        }

        Column(Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        ) {
            Column(Modifier.fillMaxWidth().offset(y = (-60).dp), verticalArrangement = Arrangement.spacedBy(19.dp)) {

                Text(
                    "Gonuts\n" + "with\n" + "Donuts",
                    fontFamily = Inter,
                    fontSize = 54.sp,
                    color = Color(0xFFFF7074),
                    fontWeight = Bold,
                )

                Text(
                    "Gonuts with Donuts is a Sri Lanka dedicated food outlets for specialize manufacturing of Donuts in Colombo, Sri Lanka.",
                    fontFamily = Inter,
                    fontSize = 18.sp,
                    color = Color(0xFFFF9494),
                    fontWeight = Medium,
                )
            }
            Button(onClick = {backStack.add(HomeScreen)},
                modifier = Modifier.fillMaxWidth().offset(y = (-25).dp).height(67.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = White
                )
            ) {

                Text(
                    "Get Started",
                    fontFamily = Inter,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = SemiBold,
                )
            }
        }


    }

}