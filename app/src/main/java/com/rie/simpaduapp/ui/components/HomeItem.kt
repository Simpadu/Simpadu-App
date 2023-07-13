package com.rie.simpaduapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rie.simpaduapp.model.home.Grafik
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

@Composable
fun GrafikItem(
    title: String,
    status: String,
    modifier: Modifier = Modifier
){
    Card(
        elevation = 2.dp,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .sizeIn(minHeight = 82.dp)
        ) {
            Column {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF858597),
                    ),

                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = status,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF1F1F39),
                    )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Divider(color = Color.Red, thickness = 10.dp, modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GrafikItemPreview(){
    SimpaduAppTheme {
        GrafikItem("Status","Aktif")
    }
}