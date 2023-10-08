package com.raju.um_compose.domain.repository

import com.raju.um_compose.data.remote.dto.JokesDto

interface JokeRepository {
    suspend fun getJoke(): JokesDto
}