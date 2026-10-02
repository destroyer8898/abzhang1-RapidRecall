package com.example.abzhang1_rapidrecall

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class RapidRecallScreen() {
    MainMenu,
    SelectLength,
    Game,
    Summary,
    AttemptLog
}

@Composable
fun RapidRecallApp(
    navController: NavHostController = rememberNavController(),
    rapidRecallViewModel: RapidRecallViewModel = viewModel()
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
                    onSummaryClicked = {
                        navController.navigate(route = RapidRecallScreen.Summary.name)
                    },
                    onNewGameClicked = {
                        navController.navigate(route = RapidRecallScreen.SelectLength.name)
                    },
                    onAttemptLogClicked = {
                        navController.navigate(route = RapidRecallScreen.AttemptLog.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = RapidRecallScreen.SelectLength.name) {
                SelectLengthScreen(
                    onStartGameClicked = { chosenLength ->
                        rapidRecallViewModel.setSequenceLength(chosenLength)
                        navController.navigate(route = RapidRecallScreen.Game.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = RapidRecallScreen.Game.name) {
                GameScreen(
                    sequenceLength = rapidRecallViewModel.sequenceLength,
                    onGameFinished = {
                        navController.navigate(route = RapidRecallScreen.MainMenu.name)
                    },
                    onAttemptSubmitted = { sequenceLength, targetString, userInput ->
                        rapidRecallViewModel.recordAttempt(sequenceLength, targetString, userInput)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = RapidRecallScreen.Summary.name) {
                SummaryScreen(
                    attemptCount = rapidRecallViewModel.getAttemptCount(),
                    correctAttemptCount = rapidRecallViewModel.getCorrectAttemptCount(),
                    accuracyPercentage = rapidRecallViewModel.getAccuracyPercentage(),
                    onBackToMainMenuClicked = {
                        navController.navigate(route = RapidRecallScreen.MainMenu.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = RapidRecallScreen.AttemptLog.name) {
                AttemptLogScreen(
                    attemptList = rapidRecallViewModel.getAttemptList(),
                    attemptCount = rapidRecallViewModel.getAttemptCount(),
                    onBackToMainMenuClicked = {
                        navController.navigate(route = RapidRecallScreen.MainMenu.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}