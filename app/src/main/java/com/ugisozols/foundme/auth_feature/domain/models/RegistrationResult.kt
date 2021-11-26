package com.ugisozols.foundme.auth_feature.domain.models

import com.ugisozols.foundme.auth_feature.util.AuthError
import com.ugisozols.foundme.core.util.MainResource

data class RegistrationResult(
    val emailError : AuthError? = null,
    val passwordError : AuthError? = null,
    val confirmedPasswordError : AuthError? = null,
    val result : MainResource? = null
)