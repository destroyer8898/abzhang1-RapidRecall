package com.example.abzhang1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AttemptLogScreen (
    attemptList: List<Attempt>,
    attemptCount: Int,
    onBackToMainMenuClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Attempt Log",
            style = MaterialTheme.typography.headlineMedium
        )

        if (attemptCount == 0) {
            Text("No attempts logged yet! Finish a game to see a log entry.")
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(attemptCount) { index ->
                    val attempt = attemptList[index]
                    AttemptCard(attempt = attempt)
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }

        Button(onClick = onBackToMainMenuClicked) {
            Text("Main Menu")
        }
    }
}

@Composable
fun AttemptCard(
    attempt: Attempt,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Length: ${attempt.sequenceLength}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = if (attempt.isCorrect) "CORRECT" else "INCORRECT",
                    color = if (attempt.isCorrect) Color.Green else Color.Red,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Target: ${attempt.targetSequence}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Your Guess: ${attempt.userInput}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Time: ${attempt.timestamp}",
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}