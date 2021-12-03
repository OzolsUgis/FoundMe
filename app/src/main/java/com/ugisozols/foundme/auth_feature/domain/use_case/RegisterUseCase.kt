package com.ugisozols.foundme.auth_feature.domain.use_case

import com.ugisozols.foundme.auth_feature.domain.models.RegistrationResult
import com.ugisozols.foundme.auth_feature.domain.repository.AuthRepository
import com.ugisozols.foundme.core.util.Validation

class RegisterUseCase(
    private val repository: AuthRepository
) {
        suspend operator fun invoke(
            email: String,
            password : String,
            confirmedPassword : String
        ) : RegistrationResult{
            val emailError = Validation.validateEmail(email)
            val passwordError = Validation.validatePassword(password)
            val confirmedPasswordError = Validation.validateConfirmedPassword(confirmedPassword, password)

            if(emailError != null || passwordError !=null || confirmedPasswordError!=null){
                return RegistrationResult(
                    emailError = emailError,
                    passwordError = passwordError,
                    confirmedPasswordError = confirmedPasswordError
                )
            }

            val result = repository.register(
                email.trim(),
                password.trim(),
                confirmedPassword.trim()
            )

            return RegistrationResult(
                result = result
            )
        }
}