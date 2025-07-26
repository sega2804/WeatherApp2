package com.crypticsamsara.weather.registrationactivities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crypticsamsara.weather.viewmodel.AuthState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.crypticsamsara.weather.viewmodel.AuthViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
/*
fun RegistrationScreen(viewModel: AuthViewModel,
                       onRegisterClick: (String, String, String, String
                               , String) -> Unit,
                       onLoginClick: () -> Unit,
                       navController: NavHostController
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var state by remember { mutableStateOf("") }

    LaunchedEffect(viewModel.isRegistrationSuccessful) {
        if (viewModel.isRegistrationSuccessful) {
            navController.navigate("dashboard") {
                popUpTo("register") { inclusive = true }
            }
        }
    }

    // Box
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F9FD)),
        contentAlignment = Alignment.Center
    ) {
        // CardView
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {


            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(22.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Register", fontSize = 24.sp, fontWeight = FontWeight.Bold)

                // Spacer
                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text("First Name") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                //Spacer
                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text("Last Name") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth())

                // Spacer
                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth())


                // Spacer
                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(icon, contentDescription = null)
                        }
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                //Spacer
                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = state,
                    onValueChange = { state = it },
                    label = { Text("State") },
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth())

                // Spacer
                Spacer(Modifier.height(16.dp))

                Button(onClick = {
                    viewModel.register(firstName, lastName, email, password, state)
                }) {
                    Text("Register")
                }

                viewModel.message?.let {
                    Spacer(Modifier.height(16.dp))
                    Text(it, color = Color.Green)
                }

                TextButton(
                    onClick =
                        onLoginClick) {
                    Text("Already have an account? Login")
                }

            }

        }
    }
}*/
fun RegistrationScreen(
    viewModel: AuthViewModel,
    navController: NavHostController
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val registrationState by viewModel.registerState.collectAsState()

    LaunchedEffect(registrationState) {
        if (registrationState is AuthState.Success) {
            navController.navigate("dashboard") {
                popUpTo("register") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Create Account",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )

                // First Name Field
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text("First Name") },
                    leadingIcon = { Icon(Icons.Default.Person, null) },
                    singleLine = true,
                    isError = firstName.isNotBlank() && firstName.length < 2,
                    supportingText = {
                        if (firstName.isNotBlank() && firstName.length < 2) {
                            Text("Minimum 2 characters")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // Last Name Field
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text("Last Name") },
                    leadingIcon = { Icon(Icons.Default.Person, null) },
                    singleLine = true,
                    isError = lastName.isNotBlank() && lastName.length < 2,
                    modifier = Modifier.fillMaxWidth()
                )

                // Email Field
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    leadingIcon = { Icon(Icons.Default.Email, null) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = email.isNotBlank() && !email.isValidEmail(),
                    supportingText = {
                        if (email.isNotBlank() && !email.isValidEmail()) {
                            Text("Invalid email format")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // Password Field
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    leadingIcon = { Icon(Icons.Default.Lock, null) },
                    visualTransformation = if (passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                if (passwordVisible) Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff,
                                null
                            )
                        }
                    },
                    isError = password.isNotBlank() && password.length < 8,
                    supportingText = {
                        if (password.isNotBlank() && password.length < 8) {
                            Text("Minimum 8 characters")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // State Field
                OutlinedTextField(
                    value = state,
                    onValueChange = { state = it },
                    label = { Text("State") },
                    leadingIcon = { Icon(Icons.Default.LocationOn, null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                // Register Button
                Button(
                    onClick = {
                        viewModel.register(firstName, lastName, email, password, state)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = registrationState !is AuthState.Loading &&
                            firstName.isNotBlank() &&
                            lastName.isNotBlank() &&
                            email.isValidEmail() &&
                            password.length >= 8 &&
                            state.isNotBlank()
                ) {
                    if (registrationState is AuthState.Loading) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.onPrimary,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text("Register")
                    }
                }

                // Status Message
                when (registrationState) {
                    is AuthState.Error -> {
                        Text(
                            text = (registrationState as AuthState.Error).message,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    is AuthState.Success -> {
                        Text(
                            text = (registrationState as AuthState.Success).message,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    else -> {}
                }

                // Login Navigation
                TextButton(
                    onClick = { navController.navigate("login") },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Already have an account? Sign In")
                }
            }
        }
    }
}

private fun String.isValidEmail(): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    return matches(emailRegex.toRegex())
}