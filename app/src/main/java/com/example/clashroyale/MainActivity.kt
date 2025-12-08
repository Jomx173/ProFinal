package com.example.clashroyale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.clashroyale.ui.pantallas.cards.CardsScreen
import com.example.clashroyale.ui.pantallas.detail.DetailScreen
import com.example.clashroyale.ui.pantallas.home.HomeScreen
import com.example.clashroyale.ui.pantallas.jugador.JugadorScreen
import com.example.clashroyale.ui.theme.ClashRoyaleAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ClashRoyaleAppTheme {

                val navController = rememberNavController()
                // Control para mostrar el título sin error
                var selectedDestination by remember { mutableStateOf(Destinations.Home.ordinal) }

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(Destinations.entries[selectedDestination].label) }
                        )
                    }
                ) { paddingValues ->

                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(paddingValues)
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

        // ✔ Pantalla HOME con navegación
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

        // ✔ Pantalla de detalle de carta con parámetro
        composable(
            route = "${Destinations.Detail.route}/{cardName}",
            arguments = listOf(navArgument("cardName") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("cardName") ?: ""
            DetailScreen(cardName = name)
        }

        // ⭐ NUEVA PANTALLA Jugador
        composable(route = Destinations.Jugador.route) {
            JugadorScreen()
        }
    }
}
