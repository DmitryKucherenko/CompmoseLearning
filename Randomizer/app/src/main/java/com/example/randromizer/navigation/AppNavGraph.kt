package com.example.randromizer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavGraph (
    navHostController: NavHostController,
    firstPage: @Composable () -> Unit,
    secondPage:@Composable () -> Unit
){

    NavHost(
        navController = navHostController,
        startDestination = Screen.HOME
    ){
        composable(Screen.SECOND_PAGE){
            secondPage()
        }

        composable(Screen.HOME){
            firstPage()
        }

    }
}