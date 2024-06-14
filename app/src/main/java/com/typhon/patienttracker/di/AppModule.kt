package com.typhon.patienttracker.di

import android.app.Application
import androidx.room.Room
import com.typhon.patienttracker.data.local.PatientDatabase
import com.typhon.patienttracker.data.repository.PatientRepositoryImpl
import com.typhon.patienttracker.domain.repository.PatientRepository
import com.typhon.patienttracker.util.Constants.PATIENT_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePatientDatabase(
        app:Application
    ): PatientDatabase{
        return Room.databaseBuilder(
            app,
            PatientDatabase::class.java,
            PATIENT_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun providePatientRepository(

      db: PatientDatabase
    ):PatientRepository{
        return PatientRepositoryImpl(db.patientDao)
    }
}