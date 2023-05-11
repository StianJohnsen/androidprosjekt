package com.example.aktivitetapp

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.aktivitetapp.repository.WholeRepo

class MyApplication: Application() {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name="app_settings"
    )

    val wholeRepo: WholeRepo
        get() = ServiceLocator.provideTrainingAppRepo(this,dataStore)
}