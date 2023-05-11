package com.example.aktivitetapp.repository

import com.example.aktivitetapp.network.TrainingApiService
import com.example.aktivitetapp.network.User

class RemoteRepo(private val trainingApiService: TrainingApiService) {


    suspend fun getUser(id: Int): User {

        return trainingApiService.getUser(id)
    }
}