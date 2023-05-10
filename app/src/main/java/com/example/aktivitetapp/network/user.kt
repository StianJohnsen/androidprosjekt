package com.example.aktivitetapp.network

import com.squareup.moshi.Json

data class user (
    @Json val id: Long = 0,
    @Json val phone: String = "undefined",
    @Json val email: String = "undefined",
    @Json val name: String = "undefined",
    @Json val birth_year: String = "undefined"
)