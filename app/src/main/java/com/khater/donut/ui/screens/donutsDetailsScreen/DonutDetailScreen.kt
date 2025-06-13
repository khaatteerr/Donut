package com.khater.donut.ui.screens.donutsDetailsScreen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import com.khater.donut.R
import com.khater.donut.ui.navigation.DonutDetailScreen
import com.khater.donut.ui.theme.Inter
import com.khater.donut.ui.utils.dropShadow.dropShadow

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DonutDetailScreen(
    navBackStack: NavBackStack,
    donutDetailScreen: DonutDetailScreen,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    val donutItem = donutDetailScreen.toTodayOfferUiState()

    with(sharedTransitionScope) {
        Box(
            Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
                .background(donutItem.backgroundColor),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.42f)
                    .align(Alignment.TopCenter),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .align(TopStart)
                        .padding(top = 45.dp, start = 25.dp)
                        .size(30.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .clickable { navBackStack.removeLastOrNull() }
                        .padding(vertical = 3.2.dp, horizontal = 8.dp),
                    tint = Color(0xFFFF7074)
                )

                // Shared Image Element
                Image(
                    painter = painterResource(id = donutItem.image),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxSize()
                        .padding(80.dp)
                        .sharedElement(
                            sharedContentState = rememberSharedContentState(key = "image-${donutItem.id}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ ->
                                tween(durationMillis = 1000, easing = FastOutSlowInEasing)
                            }
                        ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.58f)
                    .align(Alignment.BottomCenter)
                    .background(White, RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 33.dp)
                        .offset(y = (-22.5).dp)
                        .size(45.dp)
                        .align(Alignment.TopEnd)
                        .dropShadow(
                            shape = RoundedCornerShape(15.dp),
                            offsetY = 4.dp,
                            blur = 40.dp,
                            color = Black.copy(0.1f),
                            spread = 0.dp
                        )
                        .background(White, RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.fav_icon),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = Color(0xFFFF7074)
                    )
                }

                Column(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .padding(horizontal = 30.dp)
                ) {
                    Spacer(Modifier.height(35.dp))

                    // Shared Title Element
                    Text(
                        donutItem.title,
                        modifier = Modifier
                            .sharedBounds(
                                sharedContentState = rememberSharedContentState(key = "title-${donutItem.id}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(durationMillis = 800, easing = FastOutSlowInEasing)
                                }
                            ),
                        fontFamily = Inter,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFFF7074)
                    )

                    Spacer(Modifier.height(33.dp))
                    Text(
                        "About Gonut",
                        fontFamily = Inter,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(0.8f)
                    )
                    Spacer(Modifier.height(16.dp))

                    // Shared Description Element
                    Text(
                        donutItem.description,
                        modifier = Modifier
                            .sharedBounds(
                                sharedContentState = rememberSharedContentState(key = "description-${donutItem.id}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(durationMillis = 800, easing = FastOutSlowInEasing)
                                }
                            ),
                        fontFamily = Inter,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black.copy(0.6f)
                    )

                    Spacer(Modifier.height(26.dp))
                    Text(
                        "Quantity",
                        fontFamily = Inter,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(0.8f)
                    )
                    Spacer(Modifier.height(19.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        QuantityBox(value = "-")
                        QuantityBox(value = "1")
                        QuantityBox(color = Black, value = "+")
                    }
                    Spacer(Modifier.height(35.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(26.dp),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    ) {
                        // Shared Price Element
                        Text(
                            "£${donutItem.newPrice}",
                            modifier = Modifier
                                .sharedBounds(
                                    sharedContentState = rememberSharedContentState(key = "price-${donutItem.id}"),
                                    animatedVisibilityScope = animatedVisibilityScope,
                                    boundsTransform = { _, _ ->
                                        tween(durationMillis = 800, easing = FastOutSlowInEasing)
                                    }
                                ),
                            fontFamily = Inter,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )

                        Box(
                            modifier = Modifier
                                .height(60.dp)
                                .weight(1f)
                                .clip(RoundedCornerShape(50.dp))
                                .background(Color(0xFFFF7074)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "Add to Cart",
                                fontFamily = Inter,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = White
                            )
                        }
                    }
                }
            }
        }
    }

//    Box(
//        Modifier
//            .fillMaxSize()
//            .navigationBarsPadding()
//            .verticalScroll(rememberScrollState())
//
//            .background(Color(0xFFFED8DF)), contentAlignment = Alignment.Center
//    ) {
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.42f)
//                .align(Alignment.TopCenter),
//            contentAlignment = Alignment.Center
//        ) {
//            Icon(
//                painter = painterResource(R.drawable.back),
//                contentDescription = null,
//                modifier = Modifier
//                    .align(TopStart)
//                    .padding(top = 45.dp, start = 25.dp)
//                    .size(30.dp)
//                    .clip(RoundedCornerShape(5.dp))
//                    .clickable { navBackStack.removeLastOrNull() }
//                    .padding(vertical = 3.2.dp, horizontal = 8.dp),
//                tint = Color(0xFFFF7074)
//            )
//
//            Image(
//                painter = painterResource(id = R.drawable.l_donut_1),
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .fillMaxSize()
//                    .padding(80.dp),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//            )
//        }
//
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.58f)
//
//                .align(Alignment.BottomCenter)
//                .background(White, RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp)),
//            contentAlignment = Alignment.Center
//        ) {
//            Box(
//                modifier = Modifier
//                    .padding(end = 33.dp)
//                    .offset(y = (-22.5).dp)
//                    .size(45.dp)
//                    .align(Alignment.TopEnd)
//                    .dropShadow(
//                        shape = RoundedCornerShape(15.dp),
//                        offsetY = 4.dp,
//                        blur = 40.dp,
//                        color = Black.copy(0.1f),
//                        spread = 0.dp
//                    )
//                    .background(White, RoundedCornerShape(15.dp)),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    painter = painterResource(R.drawable.fav_icon),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(25.dp),
//                    tint = Color(0xFFFF7074)
//                )
//            }
//
//
//            Column(
//                Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.TopCenter)
//                    .padding(horizontal = 30.dp)
//            ) {
//                Spacer(Modifier.height(35.dp))
//                Text(
//                    "Strawberry Wheel",
//                    fontFamily = Inter,
//                    fontSize = 30.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = Color(0xFFFF7074)
//                )
//                Spacer(Modifier.height(33.dp))
//                Text(
//                    "About Gonut",
//                    fontFamily = Inter,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Medium,
//                    color = Color.Black.copy(0.8f)
//                )
//                Spacer(Modifier.height(16.dp))
//                Text(
//                    "These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth.",
//                    fontFamily = Inter,
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Normal,
//                    color = Color.Black.copy(0.6f)
//                )
//                Spacer(Modifier.height(26.dp))
//                Text(
//                    "Quantity",
//                    fontFamily = Inter,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Medium,
//                    color = Color.Black.copy(0.8f)
//                )
//                Spacer(Modifier.height(19.dp))
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(20.dp)
//                ) {
//                    QuantityBox(value = "-")
//                    QuantityBox(value = "1")
//                    QuantityBox(color = Black, value = "+")
//                }
//                Spacer(Modifier.height(35.dp))
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.spacedBy(26.dp),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(bottom = 16.dp)
//                ) {
//                    Text(
//                        "£16",
//                        fontFamily = Inter,
//                        fontSize = 25.sp,
//                        fontWeight = FontWeight.SemiBold,
//                        color = Color.Black
//                    )
//
//                    Box(
//                        modifier = Modifier
//                            .height(60.dp)
//                            .weight(1f)
//                            .clip(RoundedCornerShape(50.dp))
//                            .background(
//                                Color(
//                                    0xFFFF7074
//                                )
//                            ), contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            "Add to Cart",
//                            fontFamily = Inter,
//                            fontSize = 18.sp,
//                            fontWeight = FontWeight.SemiBold,
//                            color = White
//                        )
//                    }
//
//                }
//            }
//        }
//
//    }
}


@Composable
fun QuantityBox(modifier: Modifier = Modifier, color: Color = White, value: String) {
    val textColor = if (color == Black) White else Black
    val textSize = if (value.any { it == '+' || it == '-' }) 32.sp else 22.sp
    Box(
        Modifier
            .size(45.dp)
            .dropShadow(
                shape = RoundedCornerShape(15.dp),
                offsetY = 4.dp,
                blur = 40.dp,
                color = Black.copy(0.1f),
                spread = 0.dp
            )
            .background(color, RoundedCornerShape(15.dp)), contentAlignment = Alignment.Center
    ) {
        Text(
            value,
            fontFamily = Inter,
            fontSize = textSize,
            fontWeight = FontWeight.Medium,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier

        )
    }
}