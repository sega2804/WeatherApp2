package com.crypticsamsara.weather.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crypticsamsara.weather.api.AuthApiService
import com.crypticsamsara.weather.loginactivities.LoginScreen
import com.crypticsamsara.weather.registrationactivities.RegistrationScreen
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
/*
fun AppEntry(){
    val retrofit = remember {
        Retrofit.Builder()
            .baseUrl("https://api.nysc-hackathon.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api = retrofit.create(AuthApiService::class.java)
    val viewModel = remember { AuthViewModel(api) }

    RegistrationScreen(viewModel,
           onRegisterClick  = { firstName, lastName,  email, password, state ->
        viewModel.register(firstName, lastName, email, password, state)
    },
        onLoginClick = {
            // Handle registration click
        },
        navController = rememberNavController()
    )


    LoginScreen(viewModel,
        onLoginClick = { email, phone,  password ->
            viewModel.login(email, phone, password)
        },
        onRegisterClick = {
            // Handle registration click
        },
        navController = rememberNavController()
    )

}*/

fun WeatherApp(viewModel: AuthViewModel) {
    val navController = rememberNavController()
    val apiService = rememberApiService()
    val authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(apiService))

    // Main app navigation structure
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }
        composable("register") {
            RegistrationScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }
    }
}

@Composable
private fun rememberApiService(): AuthApiService {
    val retrofit = remember {
        Retrofit.Builder()
            .baseUrl(" https://api.nysc-hackathon.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    return remember { retrofit.create(AuthApiService::class.java) }
}

class AuthViewModelFactory(
    private val apiService: AuthApiService
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            return AuthViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}