package com.rie.simpaduapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Presence : Screen("presence")
    object Notification : Screen("notification")
    object Profile : Screen("profile")
}