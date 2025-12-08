package com.example.clashroyale

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.clashroyale.ui.pantallas.cartas.CartasGridScreen
import com.example.clashroyale.Pantallas.Detail.DetailScreen
import com.example.clashroyale.data.viewmodel.SharedCartaViewModel
import com.example.clashroyale.ui.pantallas.home.HomeScreen
import com.example.clashroyale.ui.pantallas.jugador.JugadorScreen



@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

                val sharedVM: SharedCartaViewModel = viewModel()
                val navController = rememberNavController()

                Scaffold(
                    topBar = { TopAppBar(title = { Text("Clash Royale App") }) }
                ) { paddingValues ->
                    AppNavHost(
                        navController = navController,
                        sharedVM = sharedVM,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }


@Composable
fun AppNavHost(navController: NavHostController,
               sharedVM: SharedCartaViewModel,
               modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route,
        modifier = modifier
    ) {

        // HOME
        composable(route = Destinations.Home.route) {
            HomeScreen { route ->
                navController.navigate(route)
            }
        }

        // CARTAS
        composable(route = Destinations.Cards.route) {
            CartasGridScreen { carta ->

                sharedVM.setCarta(carta)
                navController.navigate(Destinations.Detail.route)
            }
        }

        // DETALLE
        composable(
            route = Destinations.Detail.route,
            arguments = listOf(navArgument("cardName") { type = NavType.StringType })
        ) { backStackEntry ->
            val carta = sharedVM.cartaSeleccionada
            DetailScreen(carta)
        }

        // JUGADOR
        composable(route = Destinations.Jugador.route) {
            JugadorScreen()
        }
    }
}
