package com.typhon.patienttracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.typhon.patienttracker.navigation.NavGraphSetup
import com.typhon.patienttracker.presentation.theme.PatientTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatientTrackerTheme {
                val navController= rememberNavController()
                NavGraphSetup(navController = navController)
            }
        }
    }
}

