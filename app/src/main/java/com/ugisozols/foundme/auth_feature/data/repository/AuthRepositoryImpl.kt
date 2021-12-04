package com.ugisozols.foundme.auth_feature.data.repository

import android.content.SharedPreferences
import com.ugisozols.foundme.R
import com.ugisozols.foundme.auth_feature.data.remote.AuthApi
import com.ugisozols.foundme.auth_feature.data.remote.requests.CreateAccountRequest
import com.ugisozols.foundme.auth_feature.domain.repository.AuthRepository
import com.ugisozols.foundme.core.util.MainResource
import com.ugisozols.foundme.core.util.Resource
import com.ugisozols.foundme.core.util.TextMessage
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api : AuthApi,
    private val sharedPreferences: SharedPreferences
) : AuthRepository {

    override suspend fun register(
        email: String,
        password: String,
        confirmedPassword: String
    ): MainResource {
        val request = CreateAccountRequest(email, password, confirmedPassword)
        return try {
            val response = api.register(request)
            if(response.successful){
                Resource.Success(Unit)
            }else{
                response.message?.let { errorMessage ->
                    Resource.Error(TextMessage.SimpleString(errorMessage))
                } ?: Resource.Error(TextMessage.StringFromResources(R.string.auth_unknown_error))
            }
        }catch (e: IOException){
            Resource.Error(
                TextMessage.StringFromResources(R.string.server_not_found)
            )
        }catch (e: HttpException){
            Resource.Error(
                TextMessage.StringFromResources(R.string.server_something_went_wrong)
            )
        }

    }

    override suspend fun login(email: String, password: String): MainResource {
        TODO("Not yet implemented")
    }
}