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
    onSummaryButtonClicked: () -> Unit,
    onNewGameButtonClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Rapid Recall! Select an option below.",
            style = MaterialTheme.typography.headlineSmall
        )
        Row(
            modifier = modifier
        ) {
            NewGameButton(
                modifier = modifier,
                onClick = onNewGameButtonClicked
            )
            SummaryButton(
                modifier = modifier,
                onClick = onSummaryButtonClicked
            )
        }
    }
}

@Composable
fun SummaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = "Gameplay Summary"
        )
    }
}

@Composable
fun NewGameButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(
            text = "New Game"
        )
    }
}