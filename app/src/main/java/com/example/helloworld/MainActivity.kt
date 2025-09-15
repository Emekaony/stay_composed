package com.example.helloworld

import android.graphics.ColorSpace
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Exercise() {
    Column (
        modifier = Modifier
            .padding(10.dp)
            .border(2.dp, Color.Red)
            .padding(5.dp)
            .border(0.8.dp, Color.Blue)
            .padding(top = 5.dp)
    ) {
        Text("Hello Master Coding App",
            color = Color.Red,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(start = 15.dp),
            textDecoration = TextDecoration.combine(
            listOf(
                TextDecoration.Underline,
                TextDecoration.LineThrough
            ),
        ))
        Text("Download it from playstore", fontSize = 8.sp)
        Image(painter = painterResource(id = R.drawable.camera),
            contentDescription = "Man holding a camera",
            modifier = Modifier.size(width = 150.dp, height = 150.dp)
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    Log.v("Dummy Logs", "You pressed the button")
                },
            ) {
                Text("press me")
            }

            OutlinedButton(
                onClick = {}
            ) {
                Text("Press")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ExercisePreview() {
    Exercise()
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .border(2.dp, Color.Red)
            .padding(15.dp)
            .border(.3.dp, Color.Green)
    ) {
        Text(
            text = "Hello Nnaemeka",
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            modifier = modifier
        )

        Text("Another text")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldTheme {
        Greeting()
    }
}