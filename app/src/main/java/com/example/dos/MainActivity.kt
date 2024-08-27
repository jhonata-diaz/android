package com.example.dos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dos.ui.theme.DosTheme
import io.sentry.Sentry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingWithButton(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingWithButton(name: String, modifier: Modifier = Modifier) {
    // El texto de saludo
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    // Agregar un botón que lanza una excepción cuando se hace clic
    Button(onClick = {
        // Aquí lanzamos una excepción que Sentry capturará automáticamente
        Sentry.captureException(Exception("This is a test exception from Sentry Button Click"))
    }) {
        Text("Click me to send exception to Sentry")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingWithButtonPreview() {
    DosTheme {
        GreetingWithButton("Android")
    }
}
