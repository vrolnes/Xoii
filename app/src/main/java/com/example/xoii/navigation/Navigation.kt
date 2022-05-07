package com.example.xoii.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.xoii.components.ZoomableImage
import com.example.xoii.ui.MainScreenComposable
import com.example.xoii.viewModels.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navigation(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreenComposable(mainViewModel = mainViewModel, navController)
        }
        composable(route = Screen.ImageViewScreen.route + "/{imageName}",
        arguments = listOf(
            navArgument("imageName"){
                type = NavType.StringType
                nullable = false
            }
        )){
            it.arguments?.getString("imageName")?.let { it1 -> ZoomableImage(imageName = it1) }
        }
    }
}