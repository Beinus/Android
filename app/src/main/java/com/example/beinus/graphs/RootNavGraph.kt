package com.example.beinus.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beinus.presentation.main.MainScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootGraph.LoginScreen.route,
        startDestination = RootGraph.MainScreen.route
    ) {
        composable(route = RootGraph.MainScreen.route) {
            MainScreen()
        }
    }
}

sealed class RootGraph(val route: String) {
    data object LoginScreen: RootGraph(route = "LoginScreen")
    data object MainScreen: RootGraph(route = "MainScreen")
}