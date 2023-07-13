package com.rie.simpaduapp.ui.screen.notification

import android.app.Notification
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
fun NotificationScreen() {
    NotificationContent()
}

@Composable
fun NotificationContent(
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
            text = stringResource(R.string.menu_notifikasi),
            style = MaterialTheme.typography.h4
        )

    }
}

@Preview(showBackground = true)
@Composable
fun NotificationContentPreview() {
    SimpaduAppTheme() {
        NotificationContent()
    }
}