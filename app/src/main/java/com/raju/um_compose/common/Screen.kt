package com.raju.um_compose.common

sealed class Screen(val rout:String){

    object MainScreen : Screen("main_screen")
    object SplashScreen : Screen("splash_screen")

    fun withArgs(vararg args:String):String{
        return buildString {
            append(rout)
            args.forEach {arg->
                append("/$arg")
            }
        }
    }
}
