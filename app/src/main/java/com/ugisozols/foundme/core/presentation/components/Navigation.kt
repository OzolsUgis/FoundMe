package com.ugisozols.foundme.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ugisozols.foundme.auth_feature.presentation.register.RegisterScreen
import com.ugisozols.foundme.core.util.Screen

@Composable
fun Navigation(
    navController: NavHostController
){
   NavHost(
       navController = navController,
       startDestination = Screen.Register.route,
       modifier = Modifier.fillMaxSize()
   ){
       composable(Screen.Register.route){
           RegisterScreen(navController = navController)
       }

   }
}