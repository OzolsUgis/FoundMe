package com.ugisozols.foundme.auth_feature.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ugisozols.foundme.auth_feature.domain.use_case.LoginUseCase
import com.ugisozols.foundme.core.domain.states.InputFieldState
import javax.inject.Inject


class LoginScreenViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(){

    private val _emailInput = mutableStateOf(InputFieldState())
    val emailInput : State<InputFieldState> = _emailInput

    private val _passwordInput = mutableStateOf(InputFieldState())
    val passwordInput : State<InputFieldState> = _passwordInput

}