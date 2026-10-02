package com.example.abzhang1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import kotlin.time.Duration.Companion.milliseconds

enum class GamePhase {
    Display,
    Input,
    Feedback
}

@Composable
fun GameScreen(
    sequenceLength: Int,
    onGameFinished: () -> Unit,
    onAttemptSubmitted: (Int, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val targetSequence = remember(sequenceLength) {
        List(sequenceLength) { (0..9).random() }
    }
    val targetString = targetSequence.joinToString("")
    var currentPhase by remember { mutableStateOf(GamePhase.Display) }
    var currentDigitDisplay by remember { mutableStateOf<Int?>(null) }
    var userInput by remember { mutableStateOf("") }
    val isCorrect = userInput == targetString

    LaunchedEffect(targetSequence) {
        if (currentPhase == GamePhase.Display) {
            for (digit in targetSequence) {
                currentDigitDisplay = digit
                kotlinx.coroutines.delay(1000.milliseconds)  // Show digit for 1 sec
                currentDigitDisplay = null
                kotlinx.coroutines.delay(200.milliseconds)  // Short gap between digits
            }
            currentPhase = GamePhase.Input
        }
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (currentPhase) {
            GamePhase.Display -> {
                Text(
                    text = currentDigitDisplay?.toString() ?: "",
                    style = MaterialTheme.typography.displayLarge
                )
            }
            GamePhase.Input -> {
                OutlinedTextField(
                    value = userInput,
                    onValueChange = {
                        userInput = it
                    },
                    label = {
                        Text("Enter the sequence")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
                Button(
                    onClick = {
                        currentPhase = GamePhase.Feedback
                        // TODO: Record log entry here!
                        onAttemptSubmitted(sequenceLength, targetString, userInput)
                    }
                ) {
                    Text("Submit")
                }
            }
            GamePhase.Feedback -> {
                Text(
                    text = if (isCorrect) "Correct" else "Incorrect",
                    color = if (isCorrect) Color.Green else Color.Red,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text("Target: $targetString")
                Text("Your Input: $userInput")

                Button(onClick = onGameFinished) {
                    Text("Continue")
                }
            }
        }
    }
}