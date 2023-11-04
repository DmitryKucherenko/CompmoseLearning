package com.example.tradeterminal.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tradeterminal.ui.theme.TradeTerminalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TradeTerminalTheme {
                val viewModel: TerminalViewModel = viewModel()
                val screenState = viewModel.state.collectAsState()
                when (val currentState = screenState.value) {
                    is TerminalScreenState.Content -> {
                       Terminal(bars = currentState.barList)
                    }
                    is TerminalScreenState.Initial -> {

                    }
                }


            }
        }
    }
}

