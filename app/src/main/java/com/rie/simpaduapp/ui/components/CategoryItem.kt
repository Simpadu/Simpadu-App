package com.rie.simpaduapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme
import com.rie.simpaduapp.ui.theme.Shapes
import java.util.Locale.Category


@Composable
fun CategoryItem(icon: ImageVector, text: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFB8B8D2),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .width(63.dp)
            .height(70.dp)
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Icon(
            imageVector = icon,
            contentDescription = "Category Icon",
            tint = Color.Blue,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            style = TextStyle(fontSize = 12.sp),
            textAlign = TextAlign.Center
        )
    }
}



@Composable
fun CategoryList() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CategoryItem(Icons.Default.Home, "KRS", onClick = { })
            CategoryItem(Icons.Default.Favorite, "KHS", onClick = { })
            CategoryItem(Icons.Default.Settings, "SKM", onClick = { })
            CategoryItem(Icons.Default.Home, "UKT", onClick = { })
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CategoryItem(Icons.Default.Favorite, "JADWAL", onClick = { })
            CategoryItem(Icons.Default.Settings, "PRESTASI", onClick = { })
            CategoryItem(Icons.Default.Home, "MAGANG", onClick = { })
            CategoryItem(Icons.Default.Favorite, "WISUDA", onClick = { })
        }
    }
}

@Preview
@Composable
fun CategoryListPreview() {
    CategoryList()
}
