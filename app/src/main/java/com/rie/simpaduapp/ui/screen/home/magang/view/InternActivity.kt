package com.rie.simpaduapp.ui.screen.home.magang.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.home.prestasi.view.AwardsScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class InternActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                InternScreen (navigateBack = { onBackPressed() })
            }
        }
    }
}