package com.example.vkclientnews


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent

import androidx.lifecycle.ViewModelProvider
import com.example.vkclientnews.ui.theme.ActivityResultTest
import com.example.vkclientnews.ui.theme.MainScreen
import com.example.vkclientnews.ui.theme.VkClientNewsTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VkClientNewsTheme {
                val launcher =
                    rememberLauncherForActivityResult(contract = VK.getVKAuthActivityResultContract()) {
                        when (it) {
                            is VKAuthenticationResult.Success -> {
                                Log.d("MainActivity", "Success auth")
                            }
                            is VKAuthenticationResult.Failed -> {
                                Log.d("MainActivity", "Failed auth")
                            }
                        }
                    }
                launcher.launch(listOf(VKScope.WALL))
                MainScreen()
            }
        }
    }
}







