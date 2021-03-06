package com.ugisozols.foundme.core.presentation.ui.theme.shapes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ugisozols.foundme.core.presentation.ui.theme.decorationObject
import com.ugisozols.foundme.core.presentation.ui.theme.decorationObjectSize


@Composable
fun DecorativeCircleCut(
    modifier: Modifier
){
    Canvas(modifier = Modifier.size(800.dp)){

        val test = Path().apply{
            moveTo(x = 0f, y = size.height)
            lineTo(x = 0f, y = size.height - 250f)
            cubicTo(500f, size.height + 50f, size.width/2f, size.height -500, size.width, size.height/2f + 200f)
            lineTo(x = size.width, y = size.height)
        }
        drawPath(test,brush = Brush.linearGradient(decorationObject))
    }

}