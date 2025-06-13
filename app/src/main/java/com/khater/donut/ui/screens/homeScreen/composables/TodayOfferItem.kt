package com.khater.donut.ui.screens.homeScreen.composables

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khater.donut.R
import com.khater.donut.ui.screens.homeScreen.uiStates.TodayOfferUiState
import com.khater.donut.ui.theme.Inter
import com.khater.donut.ui.utils.dropShadow.dropShadow

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun TodayOfferItem(
    todayOfferUiState: TodayOfferUiState,
    onItemClicked: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    with(sharedTransitionScope) {
        Box(
            modifier = Modifier
                .height(325.dp)
                .width(193.dp)
                .dropShadow(
                    color = Black.copy(0.1f),
                    offsetY = 16.dp,
                    blur = 40.dp,
                    spread = 0.dp,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            // Main content column
            Column(
                Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = false),
                        enabled = true
                    ) { onItemClicked() }
                    .background(todayOfferUiState.backgroundColor)
                    .padding(all = 15.dp)
            ) {
                Box(
                    Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.fav_icon),
                        contentDescription = "Favorite Icon",
                        tint = Color(0xFFFF7074)
                    )
                }

                // Spacer to account for image space
                Spacer(Modifier.height(130.dp + 17.dp))

                // Shared Title Element
                Text(
                    todayOfferUiState.title,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .sharedBounds(
                            sharedContentState = rememberSharedContentState(key = "title-${todayOfferUiState.id}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ ->
                                tween(durationMillis = 800, easing = FastOutSlowInEasing)
                            }
                        ),
                    fontFamily = Inter,
                    fontSize = 16.sp,
                    fontWeight = Medium,
                    color = Color.Black
                )

                Spacer(Modifier.height(9.dp))

                // Shared Description Element
                Text(
                    todayOfferUiState.description,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .sharedBounds(
                            sharedContentState = rememberSharedContentState(key = "description-${todayOfferUiState.id}"),
                            animatedVisibilityScope = animatedVisibilityScope,
                            boundsTransform = { _, _ ->
                                tween(durationMillis = 800, easing = FastOutSlowInEasing)
                            }
                        ),
                    fontFamily = Inter,
                    fontSize = 12.sp,
                    fontWeight = Normal,
                    color = Color.Black.copy(0.41f)
                )

                Spacer(Modifier.height(13.dp))

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.End)
                ) {
                    if (todayOfferUiState.isDiscounted) {
                        Text(
                            "$${todayOfferUiState.oldPrice}",
                            fontFamily = Inter,
                            fontSize = 14.sp,
                            fontWeight = SemiBold,
                            color = Color.Black.copy(0.42f),
                            textDecoration = TextDecoration.LineThrough,
                            textAlign = TextAlign.Center
                        )
                    }

                    // Shared Price Element
                    Text(
                        "$${todayOfferUiState.newPrice}",
                        modifier = Modifier
                            .sharedBounds(
                                sharedContentState = rememberSharedContentState(key = "price-${todayOfferUiState.id}"),
                                animatedVisibilityScope = animatedVisibilityScope,
                                boundsTransform = { _, _ ->
                                    tween(durationMillis = 800, easing = FastOutSlowInEasing)
                                }
                            ),
                        fontFamily = Inter,
                        fontSize = 22.sp,
                        fontWeight = SemiBold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Shared Image Element positioned outside/over the column
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = 25.dp, y = 50.dp)
                    .aspectRatio(1f)
                    .sharedElement(
                        sharedContentState = rememberSharedContentState(key = "image-${todayOfferUiState.id}"),
                        animatedVisibilityScope = animatedVisibilityScope,
                        boundsTransform = { _, _ ->
                            tween(durationMillis = 1000, easing = FastOutSlowInEasing)
                        }
                    )
            ) {
                Image(
                    painter = painterResource(todayOfferUiState.image),
                    contentDescription = "Donut Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
//    Box(
//        modifier = Modifier
//
//            .height(325.dp)
//            .width(193.dp)
//            .dropShadow(
//                color = Black.copy(0.1f),
//                offsetY = 16.dp,
//                blur = 40.dp,
//                spread = 0.dp,
//                shape = RoundedCornerShape(20.dp)
//            )
//
//
//
//    ) {
//        // Main content column
//        Column(
//            Modifier
//                .clip(RoundedCornerShape(20.dp))
//                .clickable(
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = ripple(bounded = false),
//                    enabled = true
//                ) { onItemClicked() }
//                .background(todayOfferUiState.backgroundColor)
//                .padding(all = 15.dp)
//        ) {
//            Box(
//                Modifier
//                    .size(35.dp)
//                    .clip(CircleShape)
//                    .background(Color.White),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    painter = painterResource(R.drawable.fav_icon),
//                    contentDescription = "Favorite Icon",
//                    tint = Color(0xFFFF7074)
//                )
//            }
//
//            // Spacer to account for image space
//            Spacer(Modifier.height(130.dp + 17.dp))
//
//            Text(
//                todayOfferUiState.title,
//                modifier = Modifier.padding(horizontal = 5.dp),
//                fontFamily = Inter,
//                fontSize = 16.sp,
//                fontWeight = Medium,
//                color = Color.Black
//            )
//            Spacer(Modifier.height(9.dp))
//            Text(
//                todayOfferUiState.description,
//                modifier = Modifier.padding(horizontal = 5.dp),
//                fontFamily = Inter,
//                fontSize = 12.sp,
//                fontWeight = Normal,
//                color = Color.Black.copy(0.41f)
//            )
//            Spacer(Modifier.height(13.dp))
//            Row(
//                Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.End)
//            ) {
//                if (todayOfferUiState.isDiscounted) {
//                    Text(
//                        "$${todayOfferUiState.oldPrice}",
//                        fontFamily = Inter,
//                        fontSize = 14.sp,
//                        fontWeight = SemiBold,
//                        color = Color.Black.copy(0.42f),
//                        textDecoration = TextDecoration.LineThrough,
//                        textAlign = TextAlign.Center
//                    )
//                }
//
//                Text(
//                    "$${todayOfferUiState.newPrice}",
//                    fontFamily = Inter,
//                    fontSize = 22.sp,
//                    fontWeight = SemiBold,
//                    color = Color.Black,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//
//        // Image positioned outside/over the column
//        Box(
//            modifier = Modifier
//                .size(130.dp)
//                .align(Alignment.TopEnd)
//                .offset(x = 25.dp, y = 50.dp)
//                .aspectRatio(1f) // Ensures square container
//
//        ) {
//            Image(
//                painter = painterResource(todayOfferUiState.image),
//                contentDescription = "Donut Image",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//        }
//    }
}

fun Modifier.doubleShadowDrop(
    shape: Shape,
    offset: Dp = 4.dp,
    blur: Dp = 8.dp
) = this
    .dropShadow(shape, Color.Black.copy(0.1f), blur, offset, offset)
    .dropShadow(shape, Color.White.copy(0.1f), blur, -offset, -offset)