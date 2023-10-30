package com.example.tradeterminal.presentation

import com.example.tradeterminal.data.Bar

sealed class TerminalScreenState{
    object Initial: TerminalScreenState()
    data class Content(val barList: List<Bar>):TerminalScreenState()
}
