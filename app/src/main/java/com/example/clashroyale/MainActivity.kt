package com.example.clashroyale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
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
                var selectedDestination by remember { mutableStateOf(Destinations.Home.ordinal) }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(Destinations.entries[selectedDestination].label) }
                        )

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
        startDestination = Destinations.Home.route,
        modifier = modifier
    ) {

        // ✔ Pantalla de inicio con navegación
        composable(route = Destinations.Home.route) {
            HomeScreen { route ->
                navController.navigate(route)
            }
        }

        // ✔ Pantalla lista de cartas
        composable(route = Destinations.Cards.route) {
            CardsScreen { cardName ->
                navController.navigate("${Destinations.Detail.route}/$cardName")
            }
        }

        // ✔ Pantalla de detalle con parámetro
        composable(
            route = "${Destinations.Detail.route}/{cardName}",
            arguments = listOf(navArgument("cardName") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("cardName") ?: ""
            DetailScreen(cardName = name)
        }
    }
}
