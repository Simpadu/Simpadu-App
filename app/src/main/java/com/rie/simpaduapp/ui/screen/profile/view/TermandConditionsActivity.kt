package com.rie.simpaduapp.ui.screen.profile.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.profile.TermsandConditions
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class TermandConditionsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                TermsandConditions() {
                }
            }
        }
    }
}