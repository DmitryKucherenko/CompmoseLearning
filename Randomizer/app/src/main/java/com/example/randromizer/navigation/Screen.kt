package com.example.randromizer.navigation

sealed class Screen(
    val route: String
) {
    object MainPage : Screen(HOME)
    object SecondPage : Screen(SECOND_PAGE)
    companion object {
        const val HOME = "home"
        const val SECOND_PAGE = "second_page"
    }
}