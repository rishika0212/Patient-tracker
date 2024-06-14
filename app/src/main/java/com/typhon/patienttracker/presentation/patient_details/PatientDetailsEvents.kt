package com.typhon.patienttracker.presentation.patient_details

sealed class PatientDetailsEvents {
    data class EnteredName(val name: String): PatientDetailsEvents()
    data class EnteredAge(val age: String): PatientDetailsEvents()
    data class EnteredAssignedDoctor(val doctor: String): PatientDetailsEvents()
    data class EnteredPrescription(val prescription: String): PatientDetailsEvents()
    data object SelectedMale: PatientDetailsEvents()
    data object SelectedFemale: PatientDetailsEvents()
    data object SaveButton: PatientDetailsEvents()
}