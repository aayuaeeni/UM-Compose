package com.raju.um_compose.data.remote

import com.raju.um_compose.data.remote.dto.JokesDto
import retrofit2.http.GET

interface JokesApi {

    @GET("api?format=json")
    suspend fun getJoke(): JokesDto
}