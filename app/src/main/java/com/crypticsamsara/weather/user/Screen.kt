package com.crypticsamsara.weather.user

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object DashboardScreen : Screen("dashboard")
    object Settings : Screen("settings")
    object Profile : Screen("profile")
}