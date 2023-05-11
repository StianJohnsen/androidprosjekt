package com.example.aktivitetapp.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


data class DatastoreValue(
    val phoneNum: String
)

object DatastoreKey{
    val PHONE_NUM = stringPreferencesKey("phone_num")
}


class NumberDatastore(private val dataStore: DataStore<Preferences>){


    val appNumFlow: Flow<DatastoreValue> = dataStore.data
        .catch {
                if(it is IOException){
                    it.printStackTrace()
                    emit(emptyPreferences())
                }else{
                    throw it
                }
        }
        .map { preferences ->
            val phoneNum = preferences[DatastoreKey.PHONE_NUM] ?: ""
            DatastoreValue(phoneNum)
        }

    suspend fun updatePhoneNum(newNum:String){
        dataStore.edit { preferences ->
            preferences[DatastoreKey.PHONE_NUM] = newNum
        }
    }
}