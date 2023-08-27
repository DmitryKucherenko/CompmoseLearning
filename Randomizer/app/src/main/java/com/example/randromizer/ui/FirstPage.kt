package com.example.randromizer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.randromizer.navigation.AppNavGraph
import com.example.randromizer.navigation.Screen
import com.example.randromizer.navigation.rememberNavigationState


@Preview
@Composable
fun FirstPage() {
    val navigationState = rememberNavigationState()
    var numberOne by remember {
        mutableStateOf(0)
    }

    var numberTwo by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppNavGraph(
            navHostController = navigationState.navHostController,
            firstPage = {
                FirstPage()
            },
            secondPage = {
                SecondPage(onBackPressed = {
                    navigationState.navHostController.popBackStack()
                })
            }
        )

        TextField(
            value = numberOne.toString(),
            onValueChange = { inputNumber: String -> numberOne = inputNumber.toIntOrNull() ?: 0 },
            label = { Text(text = "Input number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        TextField(
            value = numberOne.toString(),
            onValueChange = { inputNumber: String -> numberTwo = inputNumber.toIntOrNull() ?: 0 },
            label = { Text(text = "Input second number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Button(onClick = {
            navigationState.navigateTo(Screen.SECOND_PAGE)
        }) {
            Text(text = "Generate")
        }
    }
}

