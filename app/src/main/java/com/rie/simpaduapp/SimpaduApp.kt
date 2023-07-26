package com.rie.simpaduapp

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rie.simpaduapp.data.Preferences
import com.rie.simpaduapp.ui.navigation.Screen
import com.rie.simpaduapp.ui.screen.ProfileScreen
import com.rie.simpaduapp.ui.screen.auth.LoginScreen
import com.rie.simpaduapp.ui.screen.home.HomeScreen
import com.rie.simpaduapp.ui.screen.notification.NotificationScreen
import com.rie.simpaduapp.ui.screen.presensi.PresenceScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

@Composable
fun SimpaduApp(){
    val navHostController: NavHostController = rememberNavController()
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    val isLogeedIn = remember { mutableStateOf(Preferences.isLoggedIn(sharedPreferences)) }
    val pref = Preferences.initPref(context, "isLoggedIn")
    val token = pref.getString("context", null).toString()

    NavHost(
        navController = navHostController,
        startDestination =
            if (isLogeedIn.value && token != "") {
                "mainScreen"
            } else {
                "loginScreen"
            }


    ) {
        auth(navHostController = navHostController)
        main(navHostController = navHostController)
    }

}

fun NavGraphBuilder.main(navHostController: NavHostController) {
    navigation(
        startDestination = Screen.Home.route,
        route = "mainScreen"
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navHostController)
        }
        composable(Screen.Presence.route) {

            PresenceScreen(navHostController)
        }
        composable(Screen.Notification.route) {

            NotificationScreen(navHostController)
        }
        composable(Screen.Profile.route) {

           ProfileScreen(navHostController)
        }
    }
}



fun NavGraphBuilder.auth(navHostController: NavHostController) {
    navigation(
        startDestination = Screen.Login.route,
        route = "loginScreen"
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navHostController = navHostController)
        }
    }
}





//@Composable
//fun BottomBar(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    BottomNavigation(
//        modifier = modifier
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//        val navigationItems = listOf(
//            NavigationItem(
//                title = stringResource(id = R.string.menu_home),
//                icon = Icons.Default.Home,
//                screen = Screen.Home
//            ),
//            NavigationItem(
//                title = stringResource(id = R.string.menu_presensi),
//                icon = Icons.Default.Description,
//                screen = Screen.Presence
//            ),
//            NavigationItem(
//                title = stringResource(id = R.string.menu_notifikasi),
//                icon = Icons.Default.NotificationsActive,
//                screen = Screen.Notification
//            ),
//            NavigationItem(
//                title = stringResource(id = R.string.menu_profile),
//                icon = Icons.Default.Person,
//                screen = Screen.Profile
//            ))
//
//        BottomNavigation {
//            navigationItems.map { item ->
//                BottomNavigationItem(
//                    icon = {
//                        Icon(
//                            imageVector = item.icon,
//                            contentDescription = item.title
//                        )
//                    },
//                    label = { Text(text = item.title) },
//                    selected = currentRoute == item.screen.route,
//                    onClick = {
//                        navController.navigate(item.screen.route) {
//                            popUpTo(navController.graph.findStartDestination().id) {
//                                saveState = true
//                            }
//                            restoreState = true
//                            launchSingleTop = true
//                        }
//                    }
//                )
//            }
//        }
//       }
//}


@Composable
fun ScaffoldApp(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    topBar: @Composable (() -> Unit) = {},
    bottomBar: @Composable () -> Unit = {},

) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        scaffoldState = rememberScaffoldState(),
    ) {
        Column(modifier.padding(it)) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpaduAppPreview(){
    SimpaduAppTheme {
        SimpaduApp()
    }
}