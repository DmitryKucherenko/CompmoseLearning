package com.example.vkclientnews


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.lifecycle.ViewModelProvider
import com.example.vkclientnews.ui.theme.MainScreen
import com.example.vkclientnews.ui.theme.VkClientNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           VkClientNewsTheme() {
               MainScreen()
           }

        }
    }
}







