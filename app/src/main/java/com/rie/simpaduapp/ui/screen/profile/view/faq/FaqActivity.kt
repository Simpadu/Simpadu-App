package com.rie.simpaduapp.ui.screen.profile.view.faq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.screen.profile.view.FAQ
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class FaqActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                FAQ(navigateBack = { onBackPressed() })
            }
        }
    }
}