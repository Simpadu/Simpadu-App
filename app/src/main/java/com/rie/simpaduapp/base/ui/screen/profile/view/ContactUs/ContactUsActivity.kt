package com.rie.simpaduapp.base.ui.screen.profile.view.ContactUs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.profile.view.ContactUs
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class ContactUsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
               ContactUs(navigateBack = { onBackPressed() })
            }
        }
    }
}