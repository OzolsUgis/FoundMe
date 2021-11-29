package com.ugisozols.foundme.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ugisozols.foundme.core.presentation.ui.theme.mainGradient
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.CircleShape
import com.ugisozols.foundme.core.presentation.ui.theme.shapes.DecorativeCircleCut

@Preview
@Composable
fun AuthScreen(
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