package com.alexander.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexander.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var msg = remember{ mutableStateOf("World")}

    Column {
        Text(text = msg.value,
            modifier = Modifier.clickable {
                if (msg.value == "World"){
                    msg.value = "Hello"
                }
                else {
                    msg.value = "World"
                }
            }
        )
        Button(onClick = {
            if (msg.value == "User : 黃植達"){
                msg.value = "Value : 行動應用"
            }
            else {
                msg.value = "User : 黃植達"
            }
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
            shape = CutCornerShape(10),
            border = BorderStroke(1.dp, Color.Red),
            elevation =  ButtonDefaults.elevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            )
        ) {
            Image(
                painterResource(id = R.drawable.astronaut),
                contentDescription = "Cart button icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = msg.value, color = Color.Red)
            Text(text = "Change Color", color = Color.Yellow)
        }

            TextField(
                value = msg.value,
                onValueChange = {
                    msg.value = it
                },
                label = { Text(text = "Your Label") },
                placeholder = { Text(text = "Your Name") },
            )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        Greeting("Android")
    }
}