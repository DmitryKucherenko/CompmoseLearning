package com.example.firstcompmoseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcompmoseproject.ui.theme.FirstCompmoseProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfo(name = "Dmitry", age = 38)
        }
    }
}

@Preview
@Composable
fun UserInfoPreview() {
     UserInfo(name="John",age = 25)
}


@Composable
fun UserInfo(name:String,age:Int){
    Column {
        repeat(10){
            Text(text = "Hello $name, your are $age")
        }


    }
}


