package com.rie.simpaduapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rie.simpaduapp.ui.navigation.NavigationItem
import com.rie.simpaduapp.ui.navigation.Screen
import com.rie.simpaduapp.ui.screen.ProfileScreen
import com.rie.simpaduapp.ui.screen.home.HomeScreen
import com.rie.simpaduapp.ui.screen.notification.NotificationScreen
import com.rie.simpaduapp.ui.screen.presensi.PresenceScreen
import com.rie.simpaduapp.ui.theme.SimpaduAppTheme

@Composable
fun SimpaduApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Presence.route) {
                PresenceScreen()
            }
            composable(Screen.Notification.route) {
                NotificationScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }

    }}
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_presensi),
                icon = Icons.Default.Description,
                screen = Screen.Presence
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_notifikasi),
                icon = Icons.Default.NotificationsActive,
                screen = Screen.Notification
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.Person,
                screen = Screen.Profile
            ))

        BottomNavigation {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
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