package com.rie.simpaduapp.ui.screen.notification

import android.app.Notification
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.screen.notification.view.Announcement
import com.rie.simpaduapp.ui.screen.notification.view.Reminder
import com.rie.simpaduapp.ui.screen.presensi.PresenceScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

@Composable
fun NotificationScreen() {
    val tabs = remember { mutableStateListOf("Notifikasi", "Pengumuman") }
    val selectedTabIndex = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifikasi") },
                contentColor = Color.Black,
                elevation = 10.dp
            )
        },
        content = { it
            Column(modifier = Modifier.fillMaxSize()) {
                TabRow(
                    selectedTabIndex = selectedTabIndex.value,
                    backgroundColor = Color.White,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
                            color = Color(0XFF26C6DA)
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex.value == index,
                            onClick = { selectedTabIndex.value = index },
                            text = { Text(title) }
                        )
                    }
                }
                when (selectedTabIndex.value) {
                    0 -> Reminder()
                    1 -> Announcement()
                }
            }
        }
    )
}


@Preview
@Composable
fun NotificationScreenPreview() {
    NotificationScreen()
}
