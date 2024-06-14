package com.typhon.patienttracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.typhon.patienttracker.domain.model.Patient

@Database(
    entities = [Patient::class],
    version = 1
)

abstract class PatientDatabase: RoomDatabase() {

    abstract val patientDao:PatientDao
}