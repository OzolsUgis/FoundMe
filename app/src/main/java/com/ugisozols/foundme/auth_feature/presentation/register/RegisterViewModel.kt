package com.ugisozols.foundme.auth_feature.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugisozols.foundme.R
import com.ugisozols.foundme.auth_feature.domain.use_case.RegisterUseCase
import com.ugisozols.foundme.auth_feature.presentation.register.util.RegistrationProcess
import com.ugisozols.foundme.auth_feature.presentation.register.util.RegistrationProcessState
import com.ugisozols.foundme.auth_feature.util.AuthError
import com.ugisozols.foundme.core.domain.states.InputFieldState
import com.ugisozols.foundme.core.presentation.components.UiAction
import com.ugisozols.foundme.core.util.Resource
import com.ugisozols.foundme.core.util.TextMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _emailState = mutableStateOf(InputFieldState())
    val emailState : State<InputFieldState> = _emailState

    private val _passwordState = mutableStateOf(InputFieldState())
    val passwordState : State<InputFieldState> = _passwordState

    private val _confirmedPasswordState = mutableStateOf(InputFieldState())
    val confirmedPasswordState : State<InputFieldState> = _confirmedPasswordState

    private val _registerProcessState = mutableStateOf(RegistrationProcessState())
    val registrationProcessState : State<RegistrationProcessState> = _registerProcessState

    private val _event = MutableSharedFlow<UiAction>()
    val event = _event.asSharedFlow()


    fun onEvent(process : RegistrationProcess){
        when(process){
            is RegistrationProcess.EmailInput -> {
                _emailState.value = _emailState.value.copy(
                    text = process.inputValue
                )
            }
            is RegistrationProcess.PasswordInput -> {
                _passwordState.value = _passwordState.value.copy(
                    text = process.inputValue
                )
            }
            is RegistrationProcess.ConfirmedPasswordInput -> {
                _confirmedPasswordState.value = _confirmedPasswordState.value.copy(
                    text = process.inputValue
                )
            }
            is RegistrationProcess.Register ->{
                register()
            }
        }
    }

    fun register(){
        viewModelScope.launch {
            _registerProcessState.value = RegistrationProcessState(isLoading = true)
            _emailState.value = emailState.value.copy(error = null)
            _passwordState.value = passwordState.value.copy(error = null)
            _confirmedPasswordState.value = confirmedPasswordState.value.copy(error = null)

            val registerResult = registerUseCase(
                email = emailState.value.text,
                password = passwordState.value.text,
                confirmedPassword = confirmedPasswordState.value.text
            )

            if(registerResult.emailError != null){
                _emailState.value = _emailState.value.copy(
                    error = registerResult.emailError
                )
            }

            if(registerResult.passwordError != null){
                _passwordState.value = _passwordState.value.copy(
                    error = registerResult.passwordError
                )
            }

            if(registerResult.confirmedPasswordError != null){
                _confirmedPasswordState.value = _confirmedPasswordState.value.copy(
                    error = registerResult.confirmedPasswordError
                )
            }
            when(registerResult.result){
                is Resource.Success ->{
                    Timber.d("This is fro success state")
                    _event.emit(
                        UiAction.ShowSnackbar(
                            TextMessage.StringFromResources(R.string.auth_successfully_registered)
                        )
                    )
                    _registerProcessState.value = RegistrationProcessState(isLoading = false)
                    _emailState.value = InputFieldState()
                    _passwordState.value = InputFieldState()
                    _confirmedPasswordState.value = InputFieldState()
                }
                is Resource.Error ->{
                    _event.emit(
                        UiAction.ShowSnackbar(
                            TextMessage.StringFromResources(R.string.auth_unknown_error)
                        )
                    )
                    _registerProcessState.value = RegistrationProcessState(isLoading = false)
                }
                null -> {
                    _registerProcessState.value = RegistrationProcessState(isLoading = false)
                }
            }
        }

    }
}