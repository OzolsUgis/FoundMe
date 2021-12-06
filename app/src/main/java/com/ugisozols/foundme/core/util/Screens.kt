package com.ugisozols.foundme.core.util

sealed class Screen(val route : String){
    object Register : Screen(ScreenRoutes.REGISTER)
    object Login : Screen(ScreenRoutes.LOGIN)
}
