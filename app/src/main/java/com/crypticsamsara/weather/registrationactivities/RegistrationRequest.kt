package com.crypticsamsara.weather.registrationactivities




data class RegistrationRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val state: String
) {
    fun isValid(): Boolean =
        firstName.isNotBlank() &&
                lastName.isNotBlank() &&
                email.isValidEmail() &&
                phoneNumber.isNotBlank() &&
                password.length >= 8 &&
                state.isNotBlank()

    private fun String.isValidEmail(): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return matches(emailRegex.toRegex())
    }
}