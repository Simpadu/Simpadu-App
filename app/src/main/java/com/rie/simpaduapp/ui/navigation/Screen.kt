package com.rie.simpaduapp.ui.navigation

sealed class Screen(val route: String) {

    object Splash: Screen("splash")
    object Login: Screen("login")
    object ForgotPassword: Screen("forgotPassword")
    object Home : Screen("home")
    object Presence : Screen("presence")
    object Notification : Screen("notification")
    object Profile : Screen("profile")
}