package com.example.firstcompmoseproject

import InstagramProfileCard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstcompmoseproject.ui.theme.FirstCompmoseProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstCompmoseProjectTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    InstagramProfileCard()
                }
            }
        }
    }
}

@Preview
@Composable
fun testText() {
    Column() {
        Text("Hello World!", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    textDecoration = TextDecoration.combine(
                        listOf(
                            TextDecoration.Underline,
                            TextDecoration.LineThrough
                        )
                    )
                )
            ) {
               append("He")
            }

            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                    )
                )
             {
                append("llo")
            }

        })
    }

}

