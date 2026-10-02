package com.example.abzhang1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SummaryScreen(
    attemptCount: Int,
    correctAttemptCount: Int,
    accuracyPercentage: Float,
    onBackToMainMenuClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Gameplay Summary",
            style = MaterialTheme.typography.headlineMedium
        )

        if (attemptCount == 0) {
            Text("No attempts logged yet! Finish a game to see stats.")
        } else {
            // Display Total Attempts, Correct Attempts, and formatted Accuracy %
            Text("Total Number of Attempts: $attemptCount")
            Text("Number of Correct Attempts: $correctAttemptCount")
            Text(text = "Accuracy (%): " + "%.1f%%".format(accuracyPercentage))
        }

        Button(onClick = onBackToMainMenuClicked) {
            Text("Main Menu")
        }
    }
}