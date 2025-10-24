package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Example(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Example(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var progress by remember { mutableFloatStateOf(0.1f) }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().background(color = Color.White)
    ) {
        LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier.padding(10.dp).height(8.dp) ,
        color = Color.Red,
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (progress < 1) {
                        progress += 0.1f
                    } else {
                        Toast.makeText(context, "Progress cannot go any higher than $progress", Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text("Add")
            }

            Spacer(Modifier.width(10.dp))
            Button(
                onClick = {
                    if (progress  > 0.0f) {
                        progress -= 0.1f
                    } else {
                        Toast.makeText(context, "Progress cannot go any lower than $progress", Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text("Minus")
            }
        }

    }
}

@Preview
@Composable
fun ExamplePreview() {
    Example()
}