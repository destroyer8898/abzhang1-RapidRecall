package com.example.abzhang1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainMenuScreen(
    modifier: Modifier = Modifier,
    onSummaryClicked: () -> Unit,
    onNewGameClicked: () -> Unit,
    onAttemptLogClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Rapid Recall! Select an option below.",
            style = MaterialTheme.typography.headlineSmall
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onNewGameClicked
            ) {
                Text("New Game")
            }
            Button(
                onClick = onSummaryClicked
            ) {
                Text("Gameplay Summary")
            }
            Button(
                onClick = onAttemptLogClicked
            ) {
                Text("Attempt Log")
            }
        }
    }
}