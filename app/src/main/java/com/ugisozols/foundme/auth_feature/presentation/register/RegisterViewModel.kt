package com.ugisozols.foundme.auth_feature.presentation.register

import androidx.lifecycle.ViewModel
import com.ugisozols.foundme.auth_feature.data.repository.AuthRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repositoryImpl: AuthRepositoryImpl
) : ViewModel() {
}