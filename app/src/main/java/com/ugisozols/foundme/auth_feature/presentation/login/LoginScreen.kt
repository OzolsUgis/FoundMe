package com.ugisozols.foundme.auth_feature.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ugisozols.foundme.core.presentation.ui.theme.authFieldPaddingSize
import com.ugisozols.foundme.core.presentation.ui.theme.mainGradient
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.CircleShape
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.DecorativeCircleCut

@Composable
fun LoginScreen(){
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
                    .offset(x = (-75).dp, y = (-550).dp))

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

        }


    }
}

@Composable
fun EmailInputSection(
    modifier: Modifier,
    viewModel: LoginScreenViewModel = hiltViewModel()
){

}