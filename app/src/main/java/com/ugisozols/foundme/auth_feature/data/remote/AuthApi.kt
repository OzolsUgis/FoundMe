package com.ugisozols.foundme.auth_feature.data.remote

import com.ugisozols.foundme.auth_feature.data.remote.requests.AccountRequest
import com.ugisozols.foundme.auth_feature.data.remote.requests.CreateAccountRequest
import com.ugisozols.foundme.auth_feature.data.remote.responses.AuthResponse
import com.ugisozols.foundme.core.domain.models.responses.MainApiResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {

        @POST("/api/user/crate")
        suspend fun register(
            @Body request: CreateAccountRequest
        ): MainApiResponse<Unit>

        @POST("/api/user/login")
        suspend fun login(
            @Body request: AccountRequest
        ): MainApiResponse<AuthResponse>

    companion object {
        const val  BASE_URL = "http://192.168.0.102:8001"
    }
}
