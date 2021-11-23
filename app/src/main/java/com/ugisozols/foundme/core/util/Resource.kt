package com.ugisozols.foundme.core.util

typealias MainResource = Resource<Unit>

sealed class Resource<T>(
    val data :T? = null,
    val message : TextMessage? = null
){
    class Success<T>(data : T?) : Resource<T>(data)
    class Error<T>(message: TextMessage, data: T? = null) : Resource<T>(data, message)
}
