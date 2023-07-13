package com.rie.simpaduapp.ui.screen.presensi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

@Composable
fun PresenceScreen() {
    PresenceContent()
}

@Composable
fun PresenceContent(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.menu_presensi),
            style = MaterialTheme.typography.h4
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PresenceContentPreview() {
    SimpaduAppTheme() {
        PresenceContent()
    }
}