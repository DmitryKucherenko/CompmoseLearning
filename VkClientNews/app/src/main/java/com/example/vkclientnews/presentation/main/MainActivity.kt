package com.example.vkclientnews.presentation.main


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkclientnews.domain.entity.AuthState
import com.example.vkclientnews.presentation.NewsFeedApplication
import com.example.vkclientnews.presentation.ViewModelFactory
import com.example.vkclientnews.presentation.getApplicationComponent
import com.example.vkclientnews.ui.theme.*
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import javax.inject.Inject

class MainActivity : ComponentActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val component = getApplicationComponent()
            val viewModel: MainViewModel = viewModel(factory = component.getViewModelFactory())
            val authState = viewModel.authState.collectAsState(AuthState.Initial)
            val launcher =
                rememberLauncherForActivityResult(contract = VK.getVKAuthActivityResultContract()) {
                    viewModel.performAuthResult()
                }
            VkClientNewsTheme {
                when (authState.value) {
                    is AuthState.Authorized -> {
                         MainScreen()
                    }
                    is AuthState.NotAuthorized ->{
                        LoginScreen {
                            launcher.launch(listOf(VKScope.WALL, VKScope.FRIENDS))
                        }
                    }
                    else -> {

                    }
                }

            }
        }
    }
}







