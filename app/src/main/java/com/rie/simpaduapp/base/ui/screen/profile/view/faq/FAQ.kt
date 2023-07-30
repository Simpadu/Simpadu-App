package com.rie.simpaduapp.ui.screen.profile.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rie.simpaduapp.R
import com.rie.simpaduapp.model.profile.Faqs.FAQS
import com.rie.simpaduapp.ui.components.Kehadiran



@Composable
fun FAQ(
    modifier: Modifier = Modifier, navigateBack: () -> Unit
) {
    val openIndexs = remember { mutableStateOf(-1) }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "FAQ") },
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
        content = {it
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(FAQS) { index, item ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Box(modifier = Modifier.weight(1f)) {
                                ClickableText(
                                    text = AnnotatedString(item.question),
                                    onClick = {
                                        openIndexs.value =
                                            if (openIndexs.value == index) -1 else index
                                        Log.d("TESTES", openIndexs.value.toString())
                                    }
                                )
                            }
                            Icon(
                                painter = painterResource(
                                    if (openIndexs.value == index) {
                                        R.drawable.ic_keyboard_up
                                    } else {
                                        R.drawable.ic_keyboard
                                    }
                                ),
                                contentDescription = "Question Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    if (openIndexs.value == index) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            backgroundColor = Color.Gray.copy(alpha = 0.2f),
                            elevation = 0.dp
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    horizontal = 12.dp,
                                    vertical = 8.dp
                                )
                            ) {
                                Box(modifier = Modifier.weight(1f)) {
                                    Text(item.answer,  modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Justify)
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}