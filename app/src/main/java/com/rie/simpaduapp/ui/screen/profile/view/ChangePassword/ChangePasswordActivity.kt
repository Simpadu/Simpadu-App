package com.rie.simpaduapp.ui.screen.profile.view.ChangePassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.profile.view.ChangePassword
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class ChangePasswordActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                ChangePassword(navigateBack = { onBackPressed() })
            }
        }
    }
}