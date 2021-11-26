package com.ugisozols.foundme.auth_feature.data.repository

import android.content.SharedPreferences
import com.ugisozols.foundme.auth_feature.data.remote.AuthApi
import com.ugisozols.foundme.auth_feature.domain.repository.AuthRepository
import com.ugisozols.foundme.core.util.MainResource

class AuthRepositoryImpl(
    private val api : AuthApi,
    private val sharedPreferences: SharedPreferences
) : AuthRepository {

    override suspend fun register(
        email: String,
        password: String,
        confirmedPassword: String
    ): MainResource {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String): MainResource {
        TODO("Not yet implemented")
    }
}