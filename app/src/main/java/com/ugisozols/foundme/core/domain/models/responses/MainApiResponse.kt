package com.ugisozols.foundme.core.domain.models.responses

data class MainApiResponse<T>(
    val successful : Boolean,
    val message : String? = null,
    val data : T? = null
)
