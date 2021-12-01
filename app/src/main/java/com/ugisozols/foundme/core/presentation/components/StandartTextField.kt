package com.ugisozols.foundme.core.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.ugisozols.foundme.core.presentation.ui.theme.roundedCornerShapeDimensions
import com.ugisozols.foundme.core.presentation.ui.theme.standardTextFieldsBorderWidth
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
        modifier = Modifier
            .fillMaxWidth()
            .border(
                color = textColor,
                width = standardTextFieldsBorderWidth,
                shape = RoundedCornerShape(
                    roundedCornerShapeDimensions
                )
            ),
        shape = RoundedCornerShape(roundedCornerShapeDimensions),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = transparent,
            focusedIndicatorColor = transparent,
            unfocusedIndicatorColor = transparent
        ),
        value = text,
        onValueChange = { input->
            if(input.length < maxLength){
                onValueChange(input)
            }
        },
        isError = error!= "",
        singleLine = singleLine,
        maxLines = maxLines,
        visualTransformation = if(isVisible){
            VisualTransformation.None
        }else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardInput)
    )
}