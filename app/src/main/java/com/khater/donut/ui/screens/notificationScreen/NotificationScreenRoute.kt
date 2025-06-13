package com.khater.donut.ui.screens.notificationScreen

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entry
import com.khater.donut.ui.navigation.NotificationScreen

fun EntryProviderBuilder<*>.notificationScreenRoute(backStack: NavBackStack) {
    entry<NotificationScreen> {
        NotificationScreen(backStack)
    }
}