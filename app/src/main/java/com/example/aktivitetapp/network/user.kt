package com.example.aktivitetapp.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User (
    val id: Long = 0,
    val phone: String = "undefined",
    val email: String = "undefined",
    val name: String = "undefined",
    val birth_year: String = "undefined"
)