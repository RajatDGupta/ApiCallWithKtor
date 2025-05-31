package com.demo.apicallwithktor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.demo.apicallwithktor.core.route.Route
import com.demo.apicallwithktor.presenter.screens.CommentDetailScreen
import com.demo.apicallwithktor.presenter.screens.CommentsListScreen
import com.demo.apicallwithktor.presenter.ui.theme.ApiCallWithKtorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApiCallWithKtorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Route.ListScreen.route
                    ) {
                        composable(route = Route.ListScreen.route) {
                            CommentsListScreen(innerPadding) {
                                navController.navigate(route = Route.DetailScreen.route + "?text=${it}")
                            }
                        }
                        composable(
                            route = Route.DetailScreen.route + "?text={text}",
                            arguments = listOf(
                                navArgument("text") {
                                    type = NavType.StringType
                                    nullable = true
                                }
                            )
                        ) {
                            CommentDetailScreen(id = it.arguments?.getString("text") ?: "")
                        }
                    }

                }
            }
        }
    }
}