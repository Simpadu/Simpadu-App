package com.rie.simpaduapp.ui.screen.home.prestasi.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

class CreatePrestasiActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpaduAppTheme {
                CreatePrestasi(navigateBack = { onBackPressed() })
            }
        }
    }
}