package com.example.aktivitetapp.repository

import com.example.aktivitetapp.network.TrainingApiService
import com.example.aktivitetapp.network.User
import kotlin.jvm.Throws

class RemoteRepo(private val trainingApiService: TrainingApiService) {
    @Throws(Throwable::class)
    suspend fun getUser(id: Int): User {

        return trainingApiService.getUser(id)
    }
    @Throws(Throwable::class)
    suspend fun postUser(user:User): User{
        return trainingApiService.postUser(user)
    }

    @Throws(Throwable::class)
    suspend fun getUserByNum(num:String): List<User>{
        return trainingApiService.getUserByNum(num)
    }
}