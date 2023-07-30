package com.rie.simpaduapp.ui.components.Notifikasi


import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.common.UiState
import com.rie.simpaduapp.ui.screen.ViewModelFactory
import com.rie.simpaduapp.ui.screen.home.HomeViewModel
import com.rie.simpaduapp.ui.screen.notification.viewmodel.NotificationViewModel

@Composable
fun PengumumanC(
    modifier: Modifier = Modifier,
    judul: String,
    url: String
) {
    val context = LocalContext.current
    val openUrl = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        // Handle the result if needed
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .clickable {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                openUrl.launch(browserIntent)
            },
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = judul,
                    color = Color.Gray,
                    fontSize = 17.sp,
                    fontWeight = Bold
                )
            }
        }
    }
}
