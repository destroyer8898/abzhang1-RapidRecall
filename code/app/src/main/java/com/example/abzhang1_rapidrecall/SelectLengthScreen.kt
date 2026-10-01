package com.example.abzhang1_rapidrecall

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun SelectLengthScreen(
    onStartGameButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedLength by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose below how long the sequence you need to remember will be!",
            style = MaterialTheme.typography.headlineSmall
        )
        LengthSelector(
            selectedLength = 1,
            onLengthSelected = {

            }
        )
        StartGameButton(
            onClick = onStartGameButtonClicked
        )
    }
}

@Composable
fun LengthSelector(
    selectedLength: Int,
    onLengthSelected: (Int) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Text(
            text = "Selected: $selectedLength",
            style = MaterialTheme.typography.titleMedium
        )
        Slider(
            value = selectedLength.toFloat(),
            onValueChange = { onLengthSelected(it.roundToInt()) },
            valueRange = 1f..10f,
            steps = 8
        )
    }
}

@Composable
fun StartGameButton(
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