package com.example.aktivitetapp.repository

import com.example.aktivitetapp.network.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WholeRepo constructor(
    private val remoteRepo: RemoteRepo,
    private val numberDatastore: NumberDatastore)
{
    val appPreferences: Flow<DatastoreValue> = numberDatastore.appNumFlow

    suspend fun updatePhoneNum(newNum: String){
        numberDatastore.updatePhoneNum(newNum)
    }


    suspend fun getUser(id: Int): Flow<User>{
        val user = remoteRepo.getUser(id)
        return flow() {
            emit(user)
        }
    }

    suspend fun postUser(user:User): Flow<User>{
        val user = remoteRepo.postUser(user)
        return flow() {
            emit(user)
        }
    }

    suspend fun getUserByNum(num: String): Flow<List<User>>{
        val users = remoteRepo.getUserByNum(num)
        return flow() {
            emit(users)
        }
    }

}