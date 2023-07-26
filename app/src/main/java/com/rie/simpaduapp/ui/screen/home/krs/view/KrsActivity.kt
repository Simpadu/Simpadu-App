package com.rie.simpaduapp.ui.screen.home.krs.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.home.khs.view.KhsScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class KrsActivity  : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                KrsScreen (navigateBack = { onBackPressed() })
            }
        }
    }
}