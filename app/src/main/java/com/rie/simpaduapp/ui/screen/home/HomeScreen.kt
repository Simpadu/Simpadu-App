package com.rie.simpaduapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.ui.components.*
import com.rie.simpaduapp.ui.components.Home.Ipk
import com.rie.simpaduapp.ui.components.Home.Minggu
import com.rie.simpaduapp.ui.components.Home.Status
import com.rie.simpaduapp.ui.components.Home.Tsks



@Composable
fun HomeScreen() {
    HomeContent()
}

@Composable
fun HomeContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hi, Poliban") },
                backgroundColor = Color(0xFFFFFFFF),
                elevation = 2.dp,
                actions = {
                    IconButton(onClick = { /* Aksi saat ikon ditekan */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) { it
        Column(
            modifier = Modifier
                .background(Color(0xFFFFFFFF))
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            BannerItem()
            Spacer(modifier = Modifier.height(20.dp))
            HomeSection(
                title = "menu",
                content = { Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Category(onItemClick = { clickedText ->
                        println("Clicked: $clickedText")
                    })
                }}
            )
            Spacer(modifier = Modifier.height(30.dp))
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
        }
    }
}





@Preview(showBackground = true)
@Composable
fun ProfileContentPreview() {
    SimpaduAppTheme() {
        HomeContent()
    }
}