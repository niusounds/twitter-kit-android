package com.niusounds.twitterkit.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
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
            MaterialTheme {
                MainScreen(
                    onLogin = ::onLogin
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

    private fun onLogin() {
        lifecycleScope.launch {
            val session = client.authorize(this@MainActivity)
            Toast.makeText(applicationContext, "Hello ${session.userName}", Toast.LENGTH_SHORT).show()
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