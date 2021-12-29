package com.niusounds.twitterkit.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            MaterialTheme {
                MainScreen(
                    onLogin = ::onLogin
                )
            }
        }
    }

    private fun onLogin() {

    }
}

@Composable
fun MainScreen(
    onLogin: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Twitter core sample")
                },
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = onLogin,
                modifier = Modifier.align(Alignment.Center),
            ) {
                Text(text = "Login with Twitter")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MaterialTheme {
        MainScreen(
            onLogin = {},
        )
    }
}