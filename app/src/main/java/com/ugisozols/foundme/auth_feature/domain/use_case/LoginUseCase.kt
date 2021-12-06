package com.ugisozols.foundme.auth_feature.domain.use_case

import com.ugisozols.foundme.auth_feature.domain.models.LoginResult
import com.ugisozols.foundme.auth_feature.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email : String,
        password : String
    ) : LoginResult{
        val result = repository.login(email, password)
        return LoginResult(result = result)
    }
}