package com.example.aktivitetapp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.aktivitetapp.network.trainingApi
import com.example.aktivitetapp.repository.NumberDatastore
import com.example.aktivitetapp.repository.RemoteRepo
import com.example.aktivitetapp.repository.WholeRepo

object ServiceLocator {

    var wholeRepo: WholeRepo? = null


    fun provideTrainingAppRepo(context: Context, dataStore: DataStore<Preferences>): WholeRepo{
        synchronized(this){
            return wholeRepo ?: createTrainingRepo(context, dataStore)
        }
    }

    private fun createTrainingRepo(context: Context, dataStore: DataStore<Preferences>): WholeRepo{
        val remoteDatasource = createRetrofitDataSource(context)
        val numberDatasource = createNumberDatastore(dataStore)
        val newRepo = WholeRepo(remoteDatasource,numberDatasource)
        wholeRepo = newRepo
        return newRepo
    }


    private fun createRetrofitDataSource(context: Context): RemoteRepo{
        val retrofitService = trainingApi.retrofitService
        return RemoteRepo(retrofitService)
    }

    private fun createNumberDatastore(dataStore: DataStore<Preferences>): NumberDatastore{
        val numberDataSource = NumberDatastore(dataStore)
        return numberDataSource
    }

}