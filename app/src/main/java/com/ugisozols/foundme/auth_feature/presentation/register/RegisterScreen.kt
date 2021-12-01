package com.ugisozols.foundme.auth_feature.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.ugisozols.foundme.R
import com.ugisozols.foundme.auth_feature.presentation.components.AuthButton
import com.ugisozols.foundme.auth_feature.presentation.components.AuthSpacer
import com.ugisozols.foundme.core.presentation.components.StandardTextField
import com.ugisozols.foundme.core.presentation.ui.theme.authFieldPaddingSize
import com.ugisozols.foundme.core.presentation.ui.theme.mainGradient
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.CircleShape
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.DecorativeCircleCut

@Composable
fun RegisterScreen(
    navController: NavController
){
    Column(
        Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(mainGradient))) {
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
        RegisterInputSection(modifier = Modifier.align(Alignment.Start))
        PasswordInputSection(modifier = Modifier.align(Alignment.Start))
        ConfirmPasswordInputSection(modifier= Modifier.align(Alignment.Start))
        AuthSpacer()
        RegisterUserButton(modifier = Modifier.align(Alignment.End))
    }

}

@Composable
fun RegisterInputSection(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val email by viewModel.email.observeAsState(initial = "")
    Text(
        text = stringResource(id = R.string.auth_email),
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
    AuthSpacer()
    StandardTextField(
        text = email,
        onValueChange = {emailInput ->
            viewModel.onEmailChange(emailInput)
        }
    )
}


@Composable
fun PasswordInputSection(
    modifier: Modifier,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val password by viewModel.password.observeAsState(initial = "")
    Text(
        text = stringResource(id = R.string.auth_password),
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
    AuthSpacer()
    StandardTextField(
        text = password ,
        onValueChange = { passwordInput ->
            viewModel.onPasswordChange(passwordInput)
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
    val confirmedPassword by viewModel.confirmedPassword.observeAsState(initial = "")
    Text(
        text = stringResource(id = R.string.auth_confirmed_password),
        modifier = modifier,
        style = MaterialTheme.typography.body1
    )
    AuthSpacer()
    StandardTextField(
        text = confirmedPassword,
        onValueChange = {passwordInput->
            viewModel.onConfirmedPasswordChange(passwordInput)
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
    AuthButton(
        modifier = modifier,
        buttonText = stringResource(id = R.string.auth_register_button),
        onButtonClick = {
            
        }
    )
}