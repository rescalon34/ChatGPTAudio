package com.escalondev.chatgptaudio.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.escalondev.chatgptaudio.ui.screen.home.HomeScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationScreen.HomeScreen.route
    ) {
        composable(NavigationScreen.HomeScreen.route) {
            HomeScreen()
        }
    }
}
