package com.ugisozols.foundme.auth_feature.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import com.ugisozols.foundme.core.presentation.ui.theme.*

@Composable
fun AuthSpacer(){
    Spacer(modifier = Modifier.height(authFieldSpacerSize))
}

@Composable
fun AuthButton(
    modifier : Modifier,
    buttonText : String,
    onButtonClick : () -> Unit
){

    Button(
        modifier = modifier
            .border(
                width = standardTextFieldsBorderWidth,
                color = textColor,
                shape = RoundedCornerShape(roundedCornerShapeDimensions)
            )
            ,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = transparent
        ),
        shape = RoundedCornerShape(roundedCornerShapeDimensions),
        elevation = ButtonDefaults.elevation(
            defaultElevation = test,
            pressedElevation = test
        ),
        onClick = {
            onButtonClick()
        }
    ) {
        Text(text = buttonText, textAlign = TextAlign.Center , style = MaterialTheme.typography.body1)
    }
}