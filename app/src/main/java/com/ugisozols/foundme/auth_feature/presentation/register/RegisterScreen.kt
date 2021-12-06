package com.ugisozols.foundme.auth_feature.presentation.register

import android.content.Context
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ugisozols.foundme.R
import com.ugisozols.foundme.auth_feature.presentation.components.AuthButton
import com.ugisozols.foundme.auth_feature.presentation.components.AuthSpacer
import com.ugisozols.foundme.auth_feature.presentation.register.util.RegistrationProcess
import com.ugisozols.foundme.auth_feature.util.AuthError
import com.ugisozols.foundme.core.presentation.components.StandardTextField
import com.ugisozols.foundme.core.presentation.components.UiAction
import com.ugisozols.foundme.core.presentation.ui.theme.*
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.CircleShape
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.DecorativeCircleCut
import com.ugisozols.foundme.core.util.TextMessage
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

@Composable
fun RegisterScreen(
    navController: NavController,
    scaffoldState : ScaffoldState,
    viewModel : RegisterViewModel = hiltViewModel()
){

    val context = LocalContext.current
    LaunchedEffect(key1 = true){
        viewModel.event.collectLatest { action ->
            when(action){
                is UiAction.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = action.text.asString(context = context),
                        duration = SnackbarDuration.Short
                    )
                }
            }
        }
    }


    Box(modifier = Modifier.fillMaxSize()){

        Column(
            Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(mainGradient))
        )
        {
            CircleShape(
                Modifier
                    .wrapContentSize(unbounded = true)
                    .offset(x = 75.dp, y = (-550).dp))

            DecorativeCircleCut(
                Modifier
                    .wrapContentSize(unbounded = true)
            )
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(authFieldPaddingSize),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //TODO Implement Project Logo
            Spacer(modifier = Modifier.height(spacerSize))
            Spacer(modifier = Modifier.height(spacerSize))
            RegisterInputSection(modifier = Modifier.align(Alignment.Start))
            PasswordInputSection(modifier = Modifier.align(Alignment.Start))
            ConfirmPasswordInputSection(modifier= Modifier.align(Alignment.Start))
            AuthSpacer()
            RegisterUserButton(modifier = Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.height(spacerSize))
            LoginSection(navController)
        }


    }
    }



fun TextMessage.asString(context: Context): String {
    return when (this){
        is TextMessage.SimpleString -> this.value
        is TextMessage.StringFromResources -> context.getString(this.id)
    }
}


@Composable
fun RegisterInputSection(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val email = viewModel.emailState.value
    Text(
        text = stringResource(id = R.string.auth_email),
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
    AuthSpacer()
    StandardTextField(
        text = email.text,
        onValueChange = { input ->
            viewModel.onEvent(RegistrationProcess.EmailInput(input))
        },
        error = when(email.error){
            is AuthError.InvalidEmail ->{
                stringResource(id = R.string.auth_invalid_email)
            }
            is AuthError.FieldEmpty ->{
                stringResource(id = R.string.field_empty)
            }
            else -> ""
        }
    )
}


@Composable
fun PasswordInputSection(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val password = viewModel.passwordState.value
    Text(
        text = stringResource(id = R.string.auth_password),
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
    AuthSpacer()
    StandardTextField(
        text = password.text ,
        onValueChange = { input ->
            viewModel.onEvent(RegistrationProcess.PasswordInput(input))
        },
        error = when(password.error) {
            is AuthError.FieldEmpty -> {
                stringResource(id = R.string.field_empty)
            }
            is AuthError.PasswordTooShort -> {
                stringResource(id = R.string.auth_password_too_short)
            }
            else -> ""
        },
        isVisible = false,
        keyboardInput = KeyboardType.Password
    )
}


@Composable
fun ConfirmPasswordInputSection(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val confirmedPassword = viewModel.confirmedPasswordState.value
    Text(
        text = stringResource(id = R.string.auth_confirmed_password),
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
    AuthSpacer()
    StandardTextField(
        text = confirmedPassword.text,
        onValueChange = { input ->
            viewModel.onEvent(RegistrationProcess.ConfirmedPasswordInput(input))
        },
        error = when(confirmedPassword.error) {
            is AuthError.FieldEmpty -> {
                stringResource(id = R.string.field_empty)
            }
            is AuthError.PasswordsDoNotMatch -> {
                stringResource(id = R.string.auth_passwords_do_not_match)
            }
            else -> ""
        },
        isVisible = false,
        keyboardInput = KeyboardType.Password
    )
}

@Composable
fun RegisterUserButton(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val registerState = viewModel.registrationProcessState.value
    Row(modifier = modifier) {
        if(registerState.isLoading)
        CircularProgressIndicator(modifier = modifier.size(35.dp), color = textColor)
        Spacer(modifier = modifier.width(10.dp))
        AuthButton(
            modifier = modifier,
            buttonText = stringResource(id = R.string.auth_register_button),
            onButtonClick = {
                viewModel.onEvent(RegistrationProcess.Register)

            }
        )
    }
}

@Composable
fun LoginSection (
    navController: NavController
){
    Row(
        modifier = Modifier.clickable {
           // navController.navigate()
        }
            .height(registerScreenLoginButtonHeight)
            .width(registerScreenLoginButtonWidth),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.have_account))
        Spacer(modifier = Modifier.width(6.dp))
        Text(buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                append(stringResource(id = R.string.login))
            }
        })
    }

}

