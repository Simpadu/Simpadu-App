package com.rie.simpaduapp.ui.components
import com.rie.simpaduapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoginInput(
    modifier: Modifier = Modifier,
    nim: String,
    password: String,
    onNimChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    navHostController: NavHostController
) {

    val focusManager = LocalFocusManager.current
    val showPassword = remember { mutableStateOf(false) }

    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .offset(y = (-50).dp)
//            .background(Color.White)
//            .clip(shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)),
    ) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
//                .padding(top = 50.dp)
                .padding(horizontal = 8.dp),
            value = nim,
            label = { Text(text = "Username") },
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "nim") },
            onValueChange = onNimChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
//                .padding(top = 50.dp)
                .padding(horizontal = 8.dp),
            value = password,
            label = { Text(text = "Password") },
            leadingIcon = { Icon(painter = painterResource(id =R.drawable.baseline_key_24), contentDescription = "y") },
            onValueChange = onPasswordChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            trailingIcon = {
                val (icon, iconColor) = if (showPassword.value) {
                    Pair(
                        painterResource(id = R.drawable.baseline_visibility_24),
                        colorResource(id = R.color.black)
                    )
                } else {
                    Pair(painterResource(id = R.drawable.baseline_visibility_off_24), colorResource(id = R.color.black))
                }

                IconButton(onClick = { showPassword.value = !showPassword.value }) {
                    Icon(
                        icon,
                        contentDescription = "Visibility",
                        tint = iconColor
                    )
                }
            },
            visualTransformation = if (showPassword.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
        )
        ClickableText(
            text = AnnotatedString("Lupa password"),
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            style = TextStyle(textAlign = TextAlign.End),
            onClick = {
//                navHostController.navigate("forgotPassword")
            }
        )
    }
}

@Composable
fun BtnLogin(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
            .height(40.dp),
        shape = RoundedCornerShape(50),
        onClick = onClick
    ) {
        Text(text = "Login")
    }

}