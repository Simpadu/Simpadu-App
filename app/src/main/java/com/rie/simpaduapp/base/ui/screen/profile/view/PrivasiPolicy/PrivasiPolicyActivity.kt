package com.rie.simpaduapp.base.ui.screen.profile.view.PrivasiPolicy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.profile.view.PrivasiPolicy
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class PrivasiPolicyActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                PrivasiPolicy(navigateBack = { onBackPressed() })
            }
        }
    }
}