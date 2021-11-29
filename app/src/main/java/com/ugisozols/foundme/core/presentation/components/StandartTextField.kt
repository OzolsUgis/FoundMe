package com.ugisozols.foundme.core.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import com.ugisozols.foundme.core.presentation.ui.theme.roundedCornerShapeDimensions
import com.ugisozols.foundme.core.presentation.ui.theme.textColor
import com.ugisozols.foundme.core.presentation.ui.theme.transparent

@Composable
fun StandardTextField(
    text : String = "",
    maxLength : Int = 50,
    error : String = "",
    maxLines : Int = 1,
    singleLine : Boolean = true,
    isVisible : Boolean = true,
    keyboardInput : KeyboardType = KeyboardType.Text,
    onValueChange : (String) -> Unit
){
    TextField(
        shape = RoundedCornerShape(roundedCornerShapeDimensions),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = transparent,
            focusedIndicatorColor = textColor,
            unfocusedIndicatorColor = textColor
        ),
        value = text,
        onValueChange = { input->
            if(input.length < maxLength){
                onValueChange(input)
            }
        }
    )
}