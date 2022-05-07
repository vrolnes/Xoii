package com.example.xoii.navigation

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object ImageViewScreen : Screen("imageview_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
