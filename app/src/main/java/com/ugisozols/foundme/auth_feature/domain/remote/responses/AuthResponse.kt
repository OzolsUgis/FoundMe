package com.ugisozols.foundme.auth_feature.domain.remote.responses

data class AuthResponse(
    val userId : String,
    val email : String,
    val token : String
)
