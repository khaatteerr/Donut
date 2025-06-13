package com.khater.donut

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChipDefaults.Height
import androidx.compose.material3.FilterChipDefaults.Height
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.rememberNavBackStack
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.BallAnimation
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.balltrajectory.Straight
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.utils.noRippleClickable
import com.khater.donut.ui.navigation.BuyScreen
import com.khater.donut.ui.navigation.DonutDetailScreen
import com.khater.donut.ui.navigation.DonutNavGraph
import com.khater.donut.ui.navigation.FavoriteScreen
import com.khater.donut.ui.navigation.HomeScreen
import com.khater.donut.ui.navigation.NotificationScreen
import com.khater.donut.ui.navigation.OnBoardingScreen
import com.khater.donut.ui.navigation.ProfileScreen
import com.khater.donut.ui.screens.profileScreen.ProfileScreen
import com.khater.donut.ui.utils.dropShadow.dropShadow

@OptIn(ExperimentalSharedTransitionApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DonutApp() {
    val backStack = rememberNavBackStack(OnBoardingScreen)
    var selectedIndex by remember { mutableIntStateOf(0) }
    val bottomNavItems = listOf(HomeScreen, FavoriteScreen, NotificationScreen, BuyScreen, ProfileScreen)
    val showBottomNav by remember {
        derivedStateOf {
            backStack.toList().lastOrNull() in bottomNavItems
        }
    }

    LaunchedEffect(backStack.toList()) {
        val currentKey = backStack.toList().lastOrNull()
        val newIndex = bottomNavItems.indexOfFirst { it == currentKey }
        if (newIndex != -1 && newIndex != selectedIndex) {
            selectedIndex = newIndex
        }
    }
    Scaffold(modifier = Modifier
       // .navigationBarsPadding()
        ,
        bottomBar = {
            AnimatedVisibility(
                visible = showBottomNav,
                enter = slideInVertically(animationSpec = tween(600)) { it },
                exit = slideOutVertically(animationSpec = tween(600)) { 2 * it }
            ) {
                AnimatedNavigationBar(
                    modifier = Modifier.height(60.dp),
                    selectedIndex = selectedIndex,
                    ballAnimation = Parabolic(tween(300)),
                    indentAnimation = Height(tween(300)),
                    ballColor = Color(0xFFFF7074),
                    barColor = Color(0xFFFAFAFA)
                ) {
                    bottomNavItems.forEachIndexed { index, navItem ->
                        val isSelected = index == selectedIndex
                        if (isSelected) selectedIndex = index


                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .noRippleClickable() {
                                    if (!isSelected) {
                                        selectedIndex = index
                                        backStack.add(navItem)
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                painter = painterResource(
                                    id = if (isSelected) navItem.fillIcon else navItem.icon
                                ),
                                contentDescription = navItem::class.simpleName,
                                tint = Color(0xFFFF7074)
                            )
                        }
                    }
                }
            }
        }
    ) { _ ->



        SharedTransitionLayout {
            DonutNavGraph(
                backStack = backStack,
                sharedTransitionScope = this@SharedTransitionLayout
            )
        }
    }
}