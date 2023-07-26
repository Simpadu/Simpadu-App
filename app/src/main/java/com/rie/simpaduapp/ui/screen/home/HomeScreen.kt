package com.rie.simpaduapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rie.simpaduapp.ui.components.BannerItem
import com.rie.simpaduapp.ui.components.Category
import com.rie.simpaduapp.ui.components.Home.Ipk
import com.rie.simpaduapp.ui.components.Home.Minggu
import com.rie.simpaduapp.ui.components.Home.Status
import com.rie.simpaduapp.ui.components.Home.Tsks
import com.rie.simpaduapp.ui.components.HomeSection
import com.rie.simpaduapp.ui.components.navigation.BottomBar

@Composable
fun HomeScreen(navController: NavHostController) {
    HomeContent(navController)
}

@Composable
fun HomeContent(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hi, Poliban") },
                backgroundColor = Color.White,
                elevation = 2.dp,
                actions = {
                    IconButton(onClick = { /* Aksi saat ikon ditekan */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                navController = navController
            )
        },
    ) {it
        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            BannerItem()
            Spacer(modifier = Modifier.height(20.dp))
            HomeSection(
                title = "menu",
                content = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Category(onItemClick = { clickedText ->
                            println("Clicked: $clickedText")
                        })
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            HomeSection(
                title = "status",
                content = { Minggu() }
            )
            HomeSection(
                title = "status",
                content = { Status() }
            )
            HomeSection(
                title = "status",
                content = { Tsks() }
            )
            HomeSection(
                title = "status",
                content = { Ipk() }
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}


