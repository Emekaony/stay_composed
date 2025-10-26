package com.example.helloworld

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                // rebuilding the UI
                var context  = LocalContext.current
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Green
                            ),
                            title = {
                                Text("Top App Bar")
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = Color.Red
                        ) {
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                IconButton(
                                    onClick = {
                                        Toast.makeText(context, "Menu Icon Clicked", Toast.LENGTH_SHORT).show()
                                    }
                                ) {
                                    Icon(painter = painterResource(R.drawable.baseline_menu_24), contentDescription = "Menu Icon")
                                }

                                IconButton(
                                    onClick = {
                                        Toast.makeText(context, "Clock Icon Clicked", Toast.LENGTH_SHORT).show()
                                    }
                                ) {
                                    Icon(painter = painterResource(R.drawable.baseline_punch_clock_24), contentDescription = "Menu Icon")
                                }

                                IconButton(
                                    onClick = {
                                        Toast.makeText(context, "Home Icon Clicked", Toast.LENGTH_SHORT).show()
                                    }
                                ) {
                                    Icon(painter = painterResource(R.drawable.baseline_home_24), contentDescription = "Home Icon")
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BoxExample(
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
        // arrangement is for the main axis, alignment is for the cross axis
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LinearProgressIndicator(
        progress = { progress },
        modifier = Modifier
            .padding(10.dp)
            .height(8.dp) ,
        color = Color.Red,
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (progress < 1) {
                        progress += 0.01f
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
                        progress -= 0.01f
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

@Composable
fun BoxExample(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize().background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
        ) {
            Text("Hello one", modifier = Modifier.align(Alignment.TopStart),
                color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp
            )
            Text("Hello two", modifier = Modifier.align(Alignment.BottomEnd),
                color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp
            )
            Text("Hello three", modifier = Modifier.align(Alignment.CenterEnd),
                color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp
            )
        }
    }
}

@Preview
@Composable
fun BoxExamplePreview() {
    BoxExample()
}

@Preview
@Composable
fun ExamplePreview() {
    Example()
}