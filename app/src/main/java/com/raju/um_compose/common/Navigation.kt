package com.raju.um_compose.common


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raju.um_compose.presentation.ui.screen.MainScreen
import com.raju.um_compose.presentation.ui.screen.SplashScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.rout ){

        composable(route = Screen.SplashScreen.rout){
            SplashScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.rout){
            MainScreen()
        }

    }
}