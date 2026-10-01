package com.example.abzhang1_rapidrecall

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class RapidRecallScreen() {
    MainMenu,
    SelectLength,
    Game,
    Summary
}

@Composable
fun RapidRecallApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RapidRecallScreen.MainMenu.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = RapidRecallScreen.MainMenu.name) {
                MainMenuScreen(
                    onSummaryButtonClicked = {
                        navController.navigate(RapidRecallScreen.Summary.name)
                    },
                    onNewGameButtonClicked = {
                        navController.navigate(RapidRecallScreen.SelectLength.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = RapidRecallScreen.SelectLength.name) {
                SelectLengthScreen(
                    onStartGameButtonClicked = {
                        navController.navigate(RapidRecallScreen.Game.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}