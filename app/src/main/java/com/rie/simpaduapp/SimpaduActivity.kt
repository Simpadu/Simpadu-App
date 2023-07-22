package com.rie.simpaduapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.profile.AboutUs
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class SimpaduActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                SimpaduApp ()
            }
        }
    }
}