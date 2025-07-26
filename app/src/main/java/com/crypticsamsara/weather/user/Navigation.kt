package com.crypticsamsara.weather.user

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import androidx.navigation.compose.rememberNavController
import com.crypticsamsara.weather.loginactivities.LoginScreen
import com.crypticsamsara.weather.registrationactivities.RegistrationScreen
import com.crypticsamsara.weather.viewmodel.AuthViewModel


@Composable
/*
fun AppNavigation(viewModel: AuthViewModel,
                  navController: NavHostController
) {
    // Define the screens in the app
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(viewModel,
                { token, userId ->
                    navController.navigate(Screen.DashboardScreen.route)
                },
                { navController.navigate(Screen.Register.route) },
                navController)

        }

        composable(route = Screen.Register.route) {
            RegistrationScreen(viewModel, { token, userId ->
                navController.navigate(Screen.DashboardScreen.route)
            },
                { navController.navigate(Screen.Login.route) },
                navController)
        }

        composable(route = Screen.DashboardScreen.route) {
            DashBoard()
        }

        composable(route = Screen.Settings.route) {
            SettingScreen()
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
    }
} */

fun AppNavigation(viewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(viewModel, navController)
        }

        composable(Screen.Register.route) {
            RegistrationScreen(viewModel, navController)
        }

        composable(Screen.DashboardScreen.route) {
            DashBoard()
        }

        // Other screens...
    }
}