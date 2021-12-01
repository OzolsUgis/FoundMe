package com.ugisozols.foundme.auth_feature.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugisozols.foundme.auth_feature.data.repository.AuthRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repositoryImpl: AuthRepositoryImpl
) : ViewModel() {

    private val _email = MutableLiveData("")
    val email : LiveData<String> = _email

    fun onEmailChange(emailInput : String){
        _email.value = emailInput
    }

    private val _password = MutableLiveData("")
    val password : LiveData<String> = _password

    fun onPasswordChange(passwordInput : String){
        _password.value = passwordInput
    }

    private val _confirmedPassword = MutableLiveData("")
    val confirmedPassword : LiveData<String> = _confirmedPassword

    fun onConfirmedPasswordChange(passwordInput: String){
        _confirmedPassword.value = passwordInput
    }
}