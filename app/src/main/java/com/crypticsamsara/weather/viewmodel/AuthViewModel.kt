package com.crypticsamsara.weather.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crypticsamsara.weather.api.AuthApiService
import com.crypticsamsara.weather.loginactivities.LoginRequest
import com.crypticsamsara.weather.registrationactivities.RegistrationRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch



  /*  var message by mutableStateOf<String?>("null")
    var registerMessage by mutableStateOf<String?>("null")
        var isRegistrationSuccessful by mutableStateOf(false)
        private set

    // for the loginActivities
    var loginMessage by mutableStateOf<String?>("null")
    var isLoginSuccessful by mutableStateOf(false)

    fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        state: String
    ) {
        viewModelScope.launch {
            try {
                val response = api.registerUser(
                    RegistrationRequest(firstName, lastName, email, password, state)
                )
                 if (response.isSuccessful) {
                    registerMessage = "Registration successful!"
                    isRegistrationSuccessful = true
                } else {
                   registerMessage = "Failed: ${response.errorBody()?.string()}"
                     isRegistrationSuccessful = false
                }
            } catch (e: Exception) {
                registerMessage = "Error: ${e.localizedMessage}"
                isRegistrationSuccessful = false
            }
        }


    }

    // For LoginActivities
    fun login(email: String, phoneNumber: String, password: String) {
        viewModelScope.launch {
            try {
                val response = api.loginUser(
                    LoginRequest(email, phoneNumber, password)
                )
                if (response.isSuccessful) {
                    loginMessage = "Login successful!"
                    isLoginSuccessful = true
                } else {
                    loginMessage = "Login failed: ${response.errorBody()?.string()}"
                    isLoginSuccessful = false
                }
            }
            catch (e: Exception) {
                loginMessage = "Error: ${e.localizedMessage}"
                isLoginSuccessful = false
            }
        }
        }*/

    class AuthViewModel(private val api: AuthApiService) : ViewModel() {
        private val _loginState = MutableStateFlow<AuthState>(AuthState.Idle)
        val loginState: StateFlow<AuthState> = _loginState.asStateFlow()

        private val _registerState = MutableStateFlow<AuthState>(AuthState.Idle)
        val registerState: StateFlow<AuthState> = _registerState.asStateFlow()

        fun register(
            firstName: String,
            lastName: String,
            email: String,
            password: String,
            state: String
        ) {
            if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || password.isBlank()) {
                _registerState.value = AuthState.Error("All fields are required")
                return
            }

            _registerState.value = AuthState.Loading
            viewModelScope.launch {
                try {
                    val response = api.registerUser(
                        RegistrationRequest("", "", "",
                            phoneNumber = "", password = "", "")
                    )
                    if (response.isSuccessful) {
                        _registerState.value = AuthState.Success("Registration successful")
                    } else {
                        _registerState.value = AuthState.Error(
                            response.errorBody()?.string() ?: "Registration failed"
                        )
                    }
                } catch (e: Exception) {
                    _registerState.value = AuthState.Error(e.localizedMessage ?: "Unknown error")
                }
            }
        }

        fun login(email: String, phoneNumber: String, password: String) {
            if (email.isBlank() || password.isBlank()) {
                _loginState.value = AuthState.Error("Email and password are required")
                return
            }

            _loginState.value = AuthState.Loading
            viewModelScope.launch {
                try {
                    val response = api.loginUser(
                        LoginRequest(email, phoneNumber, password)
                    )
                    if (response.isSuccessful) {
                        _loginState.value = AuthState.Success("Login successful")
                    } else {
                        _loginState.value = AuthState.Error(
                            response.errorBody()?.string() ?: "Login failed"
                        )
                    }
                } catch (e: Exception) {
                    _loginState.value = AuthState.Error(e.localizedMessage ?: "Unknown error")
                }
            }
        }
    }

    sealed class AuthState {
        object Idle : AuthState()
        object Loading : AuthState()
        data class Success(val message: String) : AuthState()
        data class Error(val message: String) : AuthState()
    }


// This ViewModel handles user authentication, including registration and login.
// It uses a Retrofit API service to communicate with the backend.
// The ViewModel maintains the authentication state and provides methods to register and login users.