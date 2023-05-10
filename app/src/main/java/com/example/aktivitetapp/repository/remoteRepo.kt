package com.example.aktivitetapp.repository

import com.example.aktivitetapp.network.TrainingApiService
import com.example.aktivitetapp.network.user
import java.io.IOException

class remoteRepo(private val trainingApiService: TrainingApiService) {


    suspend fun getUser(): user{
        try {
            return trainingApiService.getUser(188) // Hardcoded id
        }catch (exception: IOException){
            throw exception
        }
    }
}