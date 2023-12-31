package com.example.randromizer

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
import com.example.randromizer.navigation.AppNavGraph
import com.example.randromizer.navigation.rememberNavigationState
import com.example.randromizer.ui.FirstPage
import com.example.randromizer.ui.SecondPage
import com.example.randromizer.ui.theme.RandromizerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandromizerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationState = rememberNavigationState()
                    AppNavGraph(
                        navHostController = navigationState.navHostController,
                        firstPage = {
                            FirstPage(navigationState)
                        },
                        secondPage = { one, two ->
                            SecondPage(
                                one = one,
                                two = two,
                                onBackPressed = {
                                    navigationState.navHostController.popBackStack()
                                })
                        }
                    )
                }
            }
        }
    }
}

