package com.ugisozols.foundme.auth_feature.domain

import com.ugisozols.foundme.core.util.MainResource

interface AuthRepository {
    suspend fun register(
        email :String,
        password : String,
        confirmedPassword : String
    ) : MainResource

    suspend fun login(
        email : String,
        password : String
    ) : MainResource
}