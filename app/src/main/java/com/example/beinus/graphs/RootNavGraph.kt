package com.example.beinus.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beinus.presentation.account_setting.login.LoginScreen
import com.example.beinus.presentation.account_setting.signup.SignUpScreen
import com.example.beinus.presentation.main.MainScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootGraph.StartScreen.route,
        startDestination = RootGraph.LoginScreen.route
    ) {
        composable(route = RootGraph.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = RootGraph.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = RootGraph.MainScreen.route) {
            MainScreen()
        }
    }
}

sealed class RootGraph(val route: String) {
    data object StartScreen: RootGraph(route = "StartScreen")
    data object LoginScreen: RootGraph(route = "LoginScreen")
    data object SignUpScreen: RootGraph(route = "SignUpScreen")
    data object MainScreen: RootGraph(route = "MainScreen")
}