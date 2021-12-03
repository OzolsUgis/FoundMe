package com.ugisozols.foundme.auth_feature.presentation.register.util

sealed class RegistrationProcess {
    data class EmailInput(val inputValue: String) : RegistrationProcess()
    data class PasswordInput(val inputValue: String) : RegistrationProcess()
    data class ConfirmedPasswordInput (val inputValue: String) : RegistrationProcess()
    object Register : RegistrationProcess()
}
