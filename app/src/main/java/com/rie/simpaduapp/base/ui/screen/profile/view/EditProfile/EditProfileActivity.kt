package com.rie.simpaduapp.base.ui.screen.profile.view.EditProfile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.profile.view.EditProfile
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class EditProfileActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                EditProfile(navigateBack = { onBackPressed() })
            }
        }
    }
}