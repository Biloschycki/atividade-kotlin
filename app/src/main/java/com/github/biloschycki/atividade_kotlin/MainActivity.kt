package com.github.biloschycki.atividade_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.biloschycki.atividade_kotlin.screens.LoginScreen
import com.github.biloschycki.atividade_kotlin.screens.MenuScreen
import com.github.biloschycki.atividade_kotlin.screens.PedidosScreen
import com.github.biloschycki.atividade_kotlin.screens.PerfilScreen
import com.github.biloschycki.atividade_kotlin.ui.theme.AtividadekotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtividadekotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "pedidos?cliente={cliente}", arguments = listOf(
                            navArgument("cliente"){defaultValue = "Cliente não cadastrado"}
                        )) {
                            PedidosScreen(modifier = Modifier.padding(innerPadding), navController, it.arguments?.getString("cliente"))
                        }
                        composable(route = "perfil/{nome}/{idade}", arguments = listOf(navArgument("nome"){type = NavType.StringType},
                            navArgument("idade"){type = NavType.IntType}
                        )) {
                            val nome: String? = it.arguments?.getString("nome","Usuário não cadastrado")
                            val idade: Int? = it.arguments?.getInt("idade", 0 )
                            PerfilScreen(modifier = Modifier.padding(innerPadding), navController, nome!!, idade!! )
                        }
                    }
                }
            }
        }
    }
}

