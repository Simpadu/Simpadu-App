package com.rie.simpaduapp.ui.screen

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.rie.simpaduapp.R
import com.rie.simpaduapp.ScaffoldApp
import com.rie.simpaduapp.data.Preferences
import com.rie.simpaduapp.ui.screen.profile.viewmodel.ProfileViewModel
import com.rie.simpaduapp.base.Result
import com.rie.simpaduapp.ui.components.navigation.BottomBar
import com.rie.simpaduapp.ui.screen.profile.view.AboutUs.AboutUsActivity
import com.rie.simpaduapp.ui.screen.profile.view.ChangePassword.ChangePasswordActivity
import com.rie.simpaduapp.ui.screen.profile.view.ContactUs.ContactUsActivity
import com.rie.simpaduapp.ui.screen.profile.view.EditProfile.EditProfileActivity
import com.rie.simpaduapp.ui.screen.profile.view.PrivasiPolicy.PrivasiPolicyActivity
import com.rie.simpaduapp.ui.screen.profile.view.TermCondition.TermandConditionsActivity
import com.rie.simpaduapp.ui.screen.profile.view.faq.FaqActivity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    var nama by remember { mutableStateOf("Mahasiswa Guest") }
    var email by remember { mutableStateOf("user@mahasiswa.poliban.ac.id") }
    var imageUser by remember { mutableStateOf("https://www.citypng.com/public/uploads/preview/free-round-flat-male-portrait-avatar-user-icon-png-11639648873oplfof4loj.png") }

    ScaffoldApp(
        topBar = { AppBar(title = "Profile") },
        bottomBar = { BottomBar(modifier = Modifier, navController = navController) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFFFF))
                    .padding(horizontal = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp),
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    elevation = 8.dp
                ) {

                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = imageUser,
                                builder = {
                                    transformations(CircleCropTransformation())
                                }
                            ),
                            contentDescription = "Profile Image",
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Hai",
                                color = Color.Gray,
                                fontSize = 15.sp
                            )
                            Text(
                                text = nama,
                                color = Color.Gray,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = email,
                                color = Color.DarkGray,
                                fontSize = 13.sp,
                                modifier = Modifier.padding(top = 7.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                ProfileCard(navHostController = navController)
            }
        }
    )
}

@Composable
fun AppBar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )
}


@Composable
fun ProfileCard( navHostController: NavHostController) {
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_editing_profile),
                    contentDescription = "Edit Profil",
                    modifier = Modifier
                        .size(24.dp)

                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("Edit Profil"),
                    onClick = {
                        val intent = Intent(context, EditProfileActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_change_password_profile),
                    contentDescription = "Ganti Password",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("Ganti Password"),
                    onClick = {
                        val intent = Intent(context, ChangePasswordActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_question),
                    contentDescription = "faq",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("FAQ"),
                    onClick = {
                        val intent = Intent(context,  FaqActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_privacy_policy),
                    contentDescription = "Kebijakan Privasi",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("Kebijakan Privasi"),
                    onClick = {
                        val intent = Intent(context, PrivasiPolicyActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_terms_conditions),
                    contentDescription = "Syarat dan Ketentuan",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("Syarat dan Ketentuan"),
                    onClick = {
                        val intent = Intent(context, TermandConditionsActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_contact),
                    contentDescription = "Hubungi Kami",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("Hubungi Kami"),
                    onClick = {
                        val intent = Intent(context, ContactUsActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_about_us),
                    contentDescription = "Tentang Kami",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("Tentang Kami"),

                    onClick = {
                        val intent = Intent(context, AboutUsActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_log_out),
                    contentDescription = "Keluar",
                    modifier = Modifier
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                ClickableText(
                    text = AnnotatedString("Keluar"),
                    onClick = {
                        showDialog.value = true
                    }
                )
            }

            if (showDialog.value) {
                AlertLogout(navController = navHostController, onDismiss = {
                    showDialog.value = false
                })
            }



        }
    }
}

@Composable
fun AlertLogout(
    navController: NavHostController,
    onDismiss: () -> Unit,
    viewModel: ProfileViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {
    Column() {
        val lifecycleOwner = LocalLifecycleOwner.current
        val context = LocalContext.current
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            title = {
                Text(text = "Keluar dari akun")
            },
            text = {
                Text("Apakah anda yakin ingin keluar?")
            },
            confirmButton = {
                OutlinedButton(
                    onClick = {
                        viewModel.logout().observe(lifecycleOwner, {
                            when (it) {
                                is Result.Loading -> {
                                    // Handle loading state if needed
                                }
                                is Result.Success -> {
                                    val sharedPreferences =
                                        context.getSharedPreferences(
                                            "my_preferences",
                                            Context.MODE_PRIVATE
                                        )
                                    Preferences.logout(sharedPreferences)
                                    navController.popBackStack()
                                    navController.navigate("loginScreen") {
                                        popUpTo(navController.graph.findStartDestination().id)
                                    }
                                }
                                is Result.Error -> {
                                    Toast.makeText(context, it.error, Toast.LENGTH_LONG).show()
                                }
                                else -> {}
                            }
                        })
                    }) {
                    Text("Konfirmasi Keluar")
                }
            },
            dismissButton = {
                Button(onClick = {
                    onDismiss()
                }) {
                    Text(text = "Batal")
                }
            }
        )
    }
}

@Composable
fun Alert403(navController: NavController) {
    Column() {
        val openDialog = remember { mutableStateOf(true)  }
        val context = LocalContext.current
        AlertDialog(
            onDismissRequest = {
                openDialog.value = true
            },
            title = {
                Text(text = "Sesi anda telah berakhir")
            },
            text = {
                Text("Silahkan login ulang untuk melanjutkan")
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                        val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                        Preferences.logout(sharedPreferences)
                        navController.popBackStack()
                        navController.navigate("loginScreen")
                    }) {
                    Text("Oke")
                }
            },
        )
    }
}