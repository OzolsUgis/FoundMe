package com.ugisozols.foundme.di

import android.content.SharedPreferences
import com.ugisozols.foundme.auth_feature.data.remote.AuthApi
import com.ugisozols.foundme.auth_feature.data.repository.AuthRepositoryImpl
import com.ugisozols.foundme.auth_feature.domain.repository.AuthRepository
import com.ugisozols.foundme.auth_feature.domain.use_case.LoginUseCase
import com.ugisozols.foundme.auth_feature.domain.use_case.RegisterUseCase
import com.ugisozols.foundme.core.util.Screen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        api : AuthApi,
        sharedPreferences: SharedPreferences
    ) : AuthRepository{
        return AuthRepositoryImpl(api,sharedPreferences)
    }
    @Provides
    @Singleton
    fun provideRegisterUseCase(
        repository: AuthRepository
    ): RegisterUseCase{
        return RegisterUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideLoginCase(repository: AuthRepository): LoginUseCase{
        return LoginUseCase(repository)
    }

}