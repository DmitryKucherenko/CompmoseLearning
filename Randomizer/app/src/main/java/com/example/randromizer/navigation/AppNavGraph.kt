package com.example.randromizer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    firstPage: @Composable () -> Unit,
    secondPage: @Composable (numberOne:Int,numberTwo:Int) -> Unit
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.HOME
    ) {
        composable(
            route = Screen.ROUTE_SECOND_SCREEN,
            arguments = listOf(
                navArgument(Screen.KEY_NUMBER_ONE) {
                    type = NavType.IntType
                },
                navArgument(Screen.KEY_NUMBER_TWO) {
                    type = NavType.IntType
                }
            )
        ) {
            val numberOne = it.arguments?.getInt(Screen.KEY_NUMBER_ONE) ?: 0
            val numberTwo = it.arguments?.getInt(Screen.KEY_NUMBER_TWO) ?: 0
            secondPage(numberOne,numberTwo)
        }

        composable(Screen.HOME) {
            firstPage()
        }

    }
}