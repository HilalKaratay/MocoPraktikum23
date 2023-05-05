package com.example.mocopraktikum23.Screens

import android.widget.Toolbar
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mocopraktikum23.BottomNavGraph
import com.example.mocopraktikum23.NavigationBarScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        //scaffoldState = scaffoldState,
        topBar = { Toolbar() },
        bottomBar = { BottomBar(navController = navController)}
    ) { BottomNavGraph(navController = navController)}
}



@Composable
fun Toolbar(){
            TopAppBar(
                // elevation = 4.dp,
                title = {
                    Text(text = "Travelbuddies",
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.Cursive,
                    )
                })
        } //Das könnte man noch ausarbeiten. Hinzufügen des NAMENS der aktuellen seite


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        NavigationBarScreen.Map,
        NavigationBarScreen.Profil,
        NavigationBarScreen.Menu,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen:NavigationBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.name)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}