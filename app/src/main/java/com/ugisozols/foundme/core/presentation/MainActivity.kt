package com.ugisozols.foundme.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ugisozols.foundme.core.presentation.components.Navigation
import com.ugisozols.foundme.core.presentation.ui.theme.FoundMeTheme
import com.ugisozols.foundme.core.presentation.ui.theme.lightPink
import com.ugisozols.foundme.core.presentation.ui.theme.mainGradient
import com.ugisozols.foundme.core.presentation.ui.theme.textColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                FoundMeTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    val navController = rememberNavController()
                    val scaffoldState = rememberScaffoldState()

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState
                    ) {
                        navController.Navigation(scaffoldState)
                    }


                }
            }
        }

    }
}

