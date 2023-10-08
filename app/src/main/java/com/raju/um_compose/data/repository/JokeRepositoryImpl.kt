package com.raju.um_compose.data.repository
import com.raju.um_compose.data.remote.JokesApi
import com.raju.um_compose.data.remote.dto.JokesDto
import com.raju.um_compose.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val api: JokesApi
) : JokeRepository {

    override suspend fun getJoke(): JokesDto {
        return api.getJoke()
    }
}