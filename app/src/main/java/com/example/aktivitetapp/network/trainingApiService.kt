package com.example.aktivitetapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


private const val API_KEY = "004E4F46-E02"

private const val BASE_URL =
    "https://wfa-media.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TrainingApiService{
    @Headers(
        "Content-Type: application/json",
        "User-Agent: android",
        "Accept: application/json",
        "Authorization: $API_KEY"
    )
    @GET("/exercise23/v3/api.php/users/{id}")
    suspend fun getUser(@Path("id") id: Int): User

    @Headers(
        "Content-Type: application/json",
        "User-Agent: android",
        "Accept: application/json",
        "Authorization: $API_KEY"
    )
    @POST("/exercise23/v3/api.php/users/")
    suspend fun postUser(@Body user: User): User

    @Headers(
        "Content-Type: application/json",
        "User-Agent: android",
        "Accept: application/json",
        "Authorization: $API_KEY"
    )
    @GET("/exercise23/v3/api.php/users/")
    suspend fun getUserByNum(@Query("phone") phone: String): List<User>
}

object trainingApi{
    val retrofitService: TrainingApiService by lazy {
        retrofit.create(TrainingApiService::class.java)
    }
}