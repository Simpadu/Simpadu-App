package com.rie.simpaduapp.ui.screen.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.rie.simpaduapp.ui.components.navigation.BottomBar
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.HomeViewModel
import com.rie.simpaduapp.ui.screen.notification.view.Announcement
import com.rie.simpaduapp.ui.screen.notification.view.Reminder
import com.rie.simpaduapp.ui.screen.notification.viewmodel.NotificationViewModel

@Composable
fun NotificationScreen(navController: NavHostController
                       ) {
    val tabs = remember { mutableStateListOf("Notifikasi", "Pengumuman") }
    val selectedTabIndex = remember { mutableStateOf(0) }



    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifikasi") },
            )
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                navController = navController
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



