package com.rie.simpaduapp.ui.screen.home.krs.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.components.Category.Krs.KRS

@Composable
fun Krs() {
    KrsContent()
}

@Composable
fun KrsContent(modifier: Modifier = Modifier) {
    Scaffold(
    ) { it
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF))
                .padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            KRS()
        }
    }
}

