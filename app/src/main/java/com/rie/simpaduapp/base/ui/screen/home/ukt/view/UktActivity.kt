package com.rie.simpaduapp.base.ui.screen.home.ukt.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.home.krs.view.KrsScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class UktActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                UktScreen (navigateBack = { onBackPressed() })
            }
        }
    }
}