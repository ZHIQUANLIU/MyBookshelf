package com.mybookshelf.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mybookshelf.ui.screens.categories.CategoriesScreen
import com.mybookshelf.ui.screens.library.LibraryScreen
import com.mybookshelf.ui.screens.reader.ReaderScreen
import com.mybookshelf.ui.screens.settings.SettingsScreen

sealed class Screen(val route: String, val title: String) {
    data object Library : Screen("library", "Library")
    data object Categories : Screen("categories", "Categories")
    data object Settings : Screen("settings", "Settings")
    data object Reader : Screen("reader/{bookId}", "Reader") {
        fun createRoute(bookId: Long) = "reader/$bookId"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBookshelfApp() {
    val navController = rememberNavController()
    val screens = listOf(Screen.Library, Screen.Categories, Screen.Settings)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val showBottomBar = currentDestination?.route?.startsWith("reader") != true

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    screens.forEach { screen ->
                        NavigationBarItem(
                            icon = {
                                when (screen) {
                                    Screen.Library -> Icon(Icons.AutoMirrored.Filled.LibraryBooks, contentDescription = "Library")
                                    Screen.Categories -> Icon(Icons.Default.Category, contentDescription = "Categories")
                                    Screen.Settings -> Icon(Icons.Default.Settings, contentDescription = "Settings")
                                    else -> {}
                                }
                            },
                            label = { Text(screen.title) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Library.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Library.route) {
                LibraryScreen(
                    onBookClick = { bookId ->
                        navController.navigate(Screen.Reader.createRoute(bookId))
                    }
                )
            }
            composable(Screen.Categories.route) {
                CategoriesScreen(
                    onBookClick = { bookId ->
                        navController.navigate(Screen.Reader.createRoute(bookId))
                    }
                )
            }
            composable(Screen.Settings.route) {
                SettingsScreen()
            }
            composable(
                route = Screen.Reader.route,
                arguments = listOf(navArgument("bookId") { type = NavType.LongType })
            ) { backStackEntry ->
                val bookId = backStackEntry.arguments?.getLong("bookId") ?: 0L
                ReaderScreen(
                    bookId = bookId,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
