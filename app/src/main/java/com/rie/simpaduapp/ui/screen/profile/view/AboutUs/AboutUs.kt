package com.rie.simpaduapp.ui.screen.profile

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rie.simpaduapp.R

@Composable
fun AboutUs(modifier: Modifier = Modifier, navigateBack: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Tentang Kami") },
                contentColor = Color.White,
                elevation = 10.dp,
                navigationIcon = {
                    IconButton(onClick =  navigateBack) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_navigate_before_24),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
    ) {it
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFC0DBCE))
                .verticalScroll(rememberScrollState())
        ) {
            Component4()
        }
    }
}



@Composable
fun Component4() {
    Ukuran(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    Color.White,
                    RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                )
        ) {
            aboutR()
        }
        AboutCart()

    }
}

@Composable
fun Ukuran(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val largeBox = measurables[0]
        val smallBox = measurables[1]
        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
        )
        val largePlaceable = largeBox.measure(looseConstraints)
        val smallPlaceable = smallBox.measure(looseConstraints)
        val height = maxOf(largePlaceable.height, smallPlaceable.height)
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            largePlaceable.placeRelative(0, 0)
            smallPlaceable.placeRelative(
                x = (constraints.maxWidth - smallPlaceable.width) / 2,
                y = height - smallPlaceable.height / 2
            )
        }
    }
}

@Composable
fun aboutR() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Your Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Developer simpadu:",
            textAlign = TextAlign.Justify,  modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Composable
fun AboutCart() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column {
                        Text(
                            text = "Noor Saputri",
                            style = TextStyle(fontSize = 14.sp)
                        )
                        Text(
                            text = "Mobile Development",
                            style = TextStyle(fontSize = 14.sp,                         color = Color.Gray
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

                Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))

                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Column {
                        Text(
                            text = "Selvia Anggraini",
                            style = TextStyle(fontSize = 14.sp)
                        )
                        Text(
                            text = "Cloud Computing",
                            style = TextStyle(fontSize = 14.sp, color = Color.Gray
                            )
                        )
                    }
                }


            }


        }
    }

}