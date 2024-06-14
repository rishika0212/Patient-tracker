@file:OptIn(ExperimentalMaterial3Api::class)

package com.typhon.patienttracker.presentation.patient_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PatientListScreen(
    onFabClicked: () -> Unit,
    onItemClicked: (Int?) -> Unit,
    viewModel: PatientListViewModel = hiltViewModel()
){

    val patientList by viewModel.patientList.collectAsState()


    Scaffold(
        topBar={ ListAppBar() },
        floatingActionButton = {
            ListFab(onFabClicked = onFabClicked)
        }
    ) {
        LazyColumn(
            contentPadding= PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){

            items(patientList){patient->
                PatientItem(
                    patient = patient,
                    onItemClicked={onItemClicked(patient.patientId)},
                    onDeleteConfirm = {viewModel.deletePatient(patient)}
                )
            }
        }
        if(patientList.isEmpty()&& !viewModel.isLoading){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center

            ){
                Text(text="Add Patient Details\nby pressing add button.",
                    style=MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center

                )
            }
        }
    }
}

@Composable
fun ListAppBar(){
    TopAppBar(
        title = {
            Text(
                text="Patient Tracker",
                style= MaterialTheme.typography.bodyLarge.copy(fontWeight= FontWeight.Bold)
            )
        }
    )
}

@Composable
fun ListFab(
    onFabClicked:() -> Unit
){
    FloatingActionButton(onClick = onFabClicked) {
        Icon(
            imageVector= Icons.Filled.Add,
            contentDescription = "Add Patient Button"
        )

    }
}