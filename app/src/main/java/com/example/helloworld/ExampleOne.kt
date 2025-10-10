package com.example.helloworld

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WithoutState(modifier: Modifier) {
    var count: Int = 0
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Count is $count")
        Button(
            onClick = {
                count++
                Log.v("Dummy Logs", "Count is $count")
            }
        ) {
            Text("+")
        }
    }
}

@Preview
@Composable
fun WithoutStatePreview() {
    WithoutState(Modifier)
}