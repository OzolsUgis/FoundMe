package com.ugisozols.foundme.core.presentation.ui.theme.shapes


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.ugisozols.foundme.core.presentation.ui.theme.decorationObject
import com.ugisozols.foundme.core.presentation.ui.theme.decorationObjectSize


@Composable
fun CircleShape(
    modifier: Modifier
) {
    Canvas(modifier = modifier.size(decorationObjectSize), onDraw = {
        drawCircle(brush = Brush.linearGradient(decorationObject))
    })
}