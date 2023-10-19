package com.example.customview.samples


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun CanvasTest() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        drawCircle(
            color = Color.Red,
            radius = 100f,
            style = Stroke(width = 1.dp.toPx()),
            center = Offset(200f, 100f)
        )

        drawLine(
            color = Color.Red,
            start = Offset(400f, 0f),
            end = Offset(500f, 200f),
            strokeWidth = 1.dp.toPx()
        )
        drawLine(
            color = Color.Red,
            start = Offset(400f, 0f),
            end = Offset(300f, 200f),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = Color.Red,
            start = Offset(500f, 0f),
            end = Offset(500f, 200f),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = Color.Red,
            start = Offset(500f, 0f),
            end = Offset(700f, 0f),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = Color.Red,
            start = Offset(500f, 100f),
            end = Offset(700f, 100f),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = Color.Red,
            start = Offset(500f, 200f),
            end = Offset(700f, 200f),
            strokeWidth = 1.dp.toPx()
        )

        drawLine(
            color = Color.Red,
            start = Offset(710f, 0f),
            end = Offset(910f, 0f),
            strokeWidth = 1.dp.toPx()
        )
        drawLine(
            color = Color.Red,
            start = Offset(710f, 0f),
            end = Offset(710f, 200f),
            strokeWidth = 1.dp.toPx()
        )


    }
}