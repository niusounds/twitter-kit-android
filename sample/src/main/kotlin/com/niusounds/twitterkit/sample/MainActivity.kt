package com.niusounds.twitterkit.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.identity.TwitterAuthClient
import com.twitter.sdk.android.core.ktx.authorize
import com.twitter.sdk.android.core.ktx.initializeTwitter
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val client by lazy { TwitterAuthClient() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTwitter()
        setContent {
            var token by remember { mutableStateOf("") }
            val scope = rememberCoroutineScope()
            MaterialTheme {
                MainScreen(
                    onLogin = {
                        scope.launch {
                            val session = client.authorize(this@MainActivity)
                            Toast.makeText(
                                applicationContext,
                                "Hello ${session.userName}",
                                Toast.LENGTH_SHORT
                            ).show()
                            token = session.authToken.token
                        }
                    },
                    token = token,
                )
            }
        }
    }

    private fun initTwitter() {
        initializeTwitter(context = this) {
            logger(DefaultLogger(Log.DEBUG))
            debug(true)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        client.onActivityResult(requestCode, resultCode, data)
    }
}

@Composable
fun MainScreen(
    onLogin: () -> Unit,
    token: String,
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = onLogin,
            ) {
                Text(text = "Login with Twitter")
            }

            if (token.isNotEmpty()) {
                Text(text = "token: $token")
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
            token = ""
        )
    }
}