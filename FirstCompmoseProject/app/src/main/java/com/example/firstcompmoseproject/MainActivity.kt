package com.example.firstcompmoseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcompmoseproject.ui.theme.FirstCompmoseProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreatingInfo(name = "Dmitry", age = 38)
        }
    }
}

@Preview
@Composable
fun Greeting() {
    val a = 5
    val name = "John"
    Text(text = "Hello $name!")
}


@Composable
fun GreatingInfo(name:String,age:Int){
    Text(text = "Hello $name, your are $age")
}


