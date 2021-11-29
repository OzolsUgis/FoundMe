package com.ugisozols.foundme.auth_feature.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.ugisozols.foundme.core.presentation.components.AuthScreen
import com.ugisozols.foundme.core.presentation.ui.theme.mainGradient
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.CircleShape
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.DecorativeCircleCut

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
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
}