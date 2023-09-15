package com.example.vkclientnews


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect

import androidx.lifecycle.ViewModelProvider
import com.example.vkclientnews.ui.theme.*
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
                SideEffect {
                    launcher.launch(listOf(VKScope.WALL))
                }

                MainScreen()
            }
        }
    }
}







