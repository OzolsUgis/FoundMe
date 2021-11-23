package com.ugisozols.foundme.auth_feature.domain.remote.requests

data class CreateAccountRequest(
    val email : String,
    val password : String,
    val confirmedPassword : String

)
