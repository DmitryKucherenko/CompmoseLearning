package com.example.vkclientnews


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkclientnews.ui.theme.*
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VkClientNewsTheme {
                val viewModel: MainViewModel = viewModel()
                val authState = viewModel.authState.observeAsState(AuthState.Initial)
                val launcher =
                    rememberLauncherForActivityResult(contract = VK.getVKAuthActivityResultContract()) {
                        viewModel.performAuthResult(it)
                    }

                when (authState.value) {
                    is AuthState.Authorized -> {
                         MainScreen()
                    }
                    is AuthState.NotAuthorized ->{
                        LoginScreen {
                            launcher.launch(listOf(VKScope.WALL))
                        }
                    }
                    else -> {

                    }
                }

            }
        }
    }
}







