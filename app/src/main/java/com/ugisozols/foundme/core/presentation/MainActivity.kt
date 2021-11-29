package com.ugisozols.foundme.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.ugisozols.foundme.core.presentation.components.Navigation
import com.ugisozols.foundme.core.presentation.ui.theme.FoundMeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                FoundMeTheme(){
                val navController = rememberNavController()
                Surface(){
                    navController.Navigation()
                }
            }
        }

    }
}

