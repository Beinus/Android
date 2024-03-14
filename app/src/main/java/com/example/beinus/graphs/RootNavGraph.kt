package com.example.beinus.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beinus.presentation.login.LoginScreen
import com.example.beinus.presentation.main.MainScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootGraph.StartScreen.route,
        startDestination = RootGraph.LoginScreen.route
    ) {
        composable(route = RootGraph.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = RootGraph.MainScreen.route) {
            MainScreen()
        }
    }
}

sealed class RootGraph(val route: String) {
    data object StartScreen: RootGraph(route = "StartScreen")
    data object LoginScreen: RootGraph(route = "LoginScreen")
    data object MainScreen: RootGraph(route = "MainScreen")
}