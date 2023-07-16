package com.rie.simpaduapp.ui.screen.home.khs.view

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.R

@Composable
fun KhsScreen(modifier: Modifier = Modifier) {
    val tabs = remember { mutableStateListOf("KHS", "Konsultasi", "Cetak") }
    val selectedTabIndex = remember { mutableStateOf(0) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "KHS") },
//                backgroundColor = GreenPressed,
                contentColor = Color.White,
                elevation = 10.dp,
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_navigate_before_24),
                            contentDescription = "Back"
                        )
                    }
                }
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
                    0 -> Khs()
                    1 -> Consultation()
                    2 -> GenerateKhs()
                }
            }
        }
    )
}


@Preview
@Composable
fun KhsScreenPreview() {
    KhsScreen()
}