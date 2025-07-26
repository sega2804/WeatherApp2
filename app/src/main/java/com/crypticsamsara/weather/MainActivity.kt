package com.crypticsamsara.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.crypticsamsara.weather.api.AuthApiService
import com.crypticsamsara.weather.ui.theme.WeatherTheme
import com.crypticsamsara.weather.viewmodel.AuthViewModel
import com.crypticsamsara.weather.viewmodel.AuthViewModelFactory
import com.crypticsamsara.weather.viewmodel.WeatherApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Retrofit + ViewModel Setup
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nysc-hackathon.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)

        setContent {
            WeatherTheme {
                val viewModel: AuthViewModel = viewModel(
                    factory = AuthViewModelFactory(retrofit)
                )
                WeatherApp(viewModel)
            }
        }

    }
}




