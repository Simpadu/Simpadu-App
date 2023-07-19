package com.rie.simpaduapp.ui.components

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.screen.home.khs.view.KhsActivity
import com.rie.simpaduapp.ui.screen.home.krs.view.KrsActivity
import com.rie.simpaduapp.ui.screen.home.magang.view.InternActivity
import com.rie.simpaduapp.ui.screen.home.prestasi.view.AwardsActivity
import com.rie.simpaduapp.ui.screen.home.skm.view.SkmActivity
import com.rie.simpaduapp.ui.screen.home.ukt.view.UktActivity
import com.rie.simpaduapp.ui.screen.home.wisuda.view.GraduationActivity
import com.rie.simpaduapp.ui.screen.profile.view.PrivasiPolicyActivity
import java.util.Locale.Category

@Composable
fun Category(onItemClick: (String) -> Unit) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            CardItem(
                icon = R.drawable.ic_description,
                text = "KRS",
                onClick = {
                    val intent = Intent(context, KrsActivity::class.java)
                    context.startActivity(intent)
                }
            )
            CardItem(icon = R.drawable.ic_description, text = "KHS",
                onClick = {
                    val intent = Intent(context, KhsActivity::class.java)
                    context.startActivity(intent)
                }
                )
            CardItem(icon = R.drawable.ic_description, text = "SKM",
                onClick = {
                    val intent = Intent(context, SkmActivity::class.java)
                    context.startActivity(intent)
                }
                )
            CardItem(icon = R.drawable.ic_description, text = "UKT",
                onClick = {
                    val intent = Intent(context, UktActivity::class.java)
                    context.startActivity(intent)
                }
                )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            CardItem(icon = R.drawable.ic_description, text = "JADWAL",
                onClick = {
                    val intent = Intent(context, PrivasiPolicyActivity::class.java)
                    context.startActivity(intent)
                }
                )
            CardItem(icon = R.drawable.ic_description, text = "PRESTASI",
                onClick = {
                    val intent = Intent(context, AwardsActivity::class.java)
                    context.startActivity(intent)
                }
                )
            CardItem(icon = R.drawable.ic_balance, text = "MAGANG",
                onClick = {
                    val intent = Intent(context, InternActivity::class.java)
                    context.startActivity(intent)
                }
                )
            CardItem(icon = R.drawable.ic_balance, text = "WISUDA",
                onClick = {
                    val intent = Intent(context, GraduationActivity::class.java)
                    context.startActivity(intent)
                }
                )
        }
    }
}

@Composable
fun CardItem(icon: Int, text: String, onClick: () -> Unit) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .width(86.dp)
            .height(80.dp)
            .padding(5.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFB8B8D2),
                shape = RoundedCornerShape(size = 5.dp)
            )
            .clickable { onClick.invoke() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Home Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                style = TextStyle(fontSize = 12.sp),
                textAlign = TextAlign.Center
            )
        }
    }
}


