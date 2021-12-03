package com.ugisozols.foundme.core.util

import com.ugisozols.foundme.auth_feature.util.AuthError
import com.ugisozols.foundme.core.util.Constants.MIN_PASSWORD_LENGTH

object Validation {

    fun validateEmail(email :String) : AuthError? {
        val trimmedEmail = email.trim()

        if(trimmedEmail.isBlank()){
            return AuthError.FieldEmpty
        }
        if(!trimmedEmail.contains('@')|| !trimmedEmail.contains('.')){
            return AuthError.InvalidEmail
        }
        return null
    }

    fun validatePassword(password : String) : AuthError? {
        val trimmedPassword = password.trim()

        if(trimmedPassword.isBlank()){
            return AuthError.FieldEmpty
        }
        if(trimmedPassword.length < MIN_PASSWORD_LENGTH){
            return AuthError.PasswordTooShort
        }
        return null
    }

    fun validateConfirmedPassword(confirmedPassword :String, password: String): AuthError? {
        val trimmedConfirmedPassword = confirmedPassword.trim()
        val trimmedPassword = password.trim()
        if(trimmedConfirmedPassword.isBlank()){
            return AuthError.FieldEmpty
        }
        if(trimmedConfirmedPassword != trimmedPassword){
            return AuthError.PasswordsDoNotMatch
        }
        return null
    }
}