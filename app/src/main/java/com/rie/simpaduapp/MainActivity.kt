package com.rie.simpaduapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rie.simpaduapp.ui.screen.auth.LoginScreen
import com.rie.simpaduapp.ui.screen.notification.NotificationScreen
import com.rie.simpaduapp.ui.screen.splashscreen.viewmodel.SplashViewModel

import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        splashScreen.setKeepOnScreenCondition{viewModel.isLoading.value}
        setContent {
            SimpaduAppTheme {
                SimpaduApp()
            }
        }
    }
}



