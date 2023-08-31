package com.example.randromizer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.randromizer.navigation.AppNavGraph
import com.example.randromizer.navigation.NavigationState
import com.example.randromizer.navigation.Screen
import com.example.randromizer.navigation.rememberNavigationState



@Composable
fun FirstPage(navigationState:NavigationState) {



    var numberOne  by rememberSaveable {
        mutableStateOf("0")
    }

    var numberTwo    by rememberSaveable {
        mutableStateOf("0")
    }



    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = numberOne,
            onValueChange = { inputNumber: String -> numberOne = inputNumber },
            label = { Text(text = "Input number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        TextField(
            value = numberTwo,
            onValueChange = { inputNumber: String -> numberTwo = inputNumber },
            label = { Text(text = "Input second number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        Button(onClick = {
            navigationState.navigateToSecondPage(numberOne.toIntOrNull() ?: 0,numberTwo.toIntOrNull() ?: 0)
        }) {
            Text(text = "Generate")
        }
    }
}

