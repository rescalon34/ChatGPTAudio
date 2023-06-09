package com.escalondev.chatgptaudio.ui.navigation

sealed class NavigationScreen(val route: String) {
    object HomeScreen : NavigationScreen("home_screen")
}
