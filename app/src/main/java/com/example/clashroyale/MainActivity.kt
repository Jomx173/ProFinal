package com.example.clashroyale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.clashroyale.ui.pantallas.cards.CardsScreen
import com.example.clashroyale.ui.pantallas.detail.DetailScreen
import com.example.clashroyale.ui.pantallas.home.HomeScreen
import com.example.clashroyale.ui.theme.ClashRoyaleAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClashRoyaleAppTheme {

                val navController: NavHostController = rememberNavController()
                var selectedDestination by remember { mutableStateOf(`Destinations.kt`.Home.ordinal) }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(`Destinations.kt`.entries[selectedDestination].label) }
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            `Destinations.kt`.entries.forEachIndexed { index, destination ->
                                NavigationBarItem(
                                    selected = selectedDestination == index,
                                    onClick = {
                                        navController.navigate(destination.route)
                                        selectedDestination = index
                                    },
                                    icon = { Icon(destination.icon, destination.description) },
                                    label = { Text(destination.label) }
                                )
                            }
                        }
                    }
                ) { padding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = `Destinations.kt`.Home.route,
        modifier = modifier
    ) {
        composable(`Destinations.kt`.Home.route) {
            HomeScreen()
        }
        composable(`Destinations.kt`.Cards.route) {
            CardsScreen { cardName ->
                navController.navigate("${`Destinations.kt`.Detail.route}/$cardName")
            }
        }
        composable("${`Destinations.kt`.Detail.route}/{cardName}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("cardName") ?: ""
            DetailScreen(cardName = name)
        }
    }
}
