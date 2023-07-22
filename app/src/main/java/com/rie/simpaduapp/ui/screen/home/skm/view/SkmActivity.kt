package com.rie.simpaduapp.ui.screen.home.skm.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.home.krs.view.KrsScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class SkmActivity  : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                SkmScreen ()
            }
        }
    }
}