package com.example.randromizer.navigation

sealed class Screen(
    val route: String
) {
    object MainPage : Screen(HOME)
    object SecondPage : Screen(SECOND_PAGE)

    fun getRouteWithArgs(one:Int,two:Int):String{
        return "comments/$one/$two"
    }

    companion object {
        const val HOME = "home"
        const val SECOND_PAGE = "second_page"
        const val KEY_NUMBER_ONE = "key_number_one"
        const val KEY_NUMBER_TWO = "key_number_two"
        const val ROUTE_SECOND_SCREEN = "comments/{$KEY_NUMBER_ONE}/{$KEY_NUMBER_TWO}"
    }
}