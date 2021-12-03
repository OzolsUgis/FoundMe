package com.ugisozols.foundme.auth_feature.util

import com.ugisozols.foundme.core.util.Error

sealed class AuthError : Error() {
    object FieldEmpty : AuthError()
    object InvalidEmail : AuthError()
    object PasswordTooShort: AuthError()
    object PasswordsDoNotMatch : AuthError()
}