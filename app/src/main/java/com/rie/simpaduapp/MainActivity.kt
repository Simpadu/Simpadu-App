package com.rie.simpaduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rie.simpaduapp.ui.screen.ProfileScreen
import com.rie.simpaduapp.ui.screen.auth.LoginScreen
import com.rie.simpaduapp.ui.screen.splashscreen.SplashScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                   ProfileScreen()
//                    LoginScreen()
//                    SplashScreen()
                    SimpaduApp()

                }
            }
        }
    }
}



