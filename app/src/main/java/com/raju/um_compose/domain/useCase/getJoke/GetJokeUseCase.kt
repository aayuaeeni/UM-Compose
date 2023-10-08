package com.raju.um_compose.domain.useCase.getJoke

import com.raju.um_compose.common.Resource
import com.raju.um_compose.data.remote.dto.toJokesDetail
import com.raju.um_compose.domain.model.JokesDetail
import com.raju.um_compose.domain.repository.JokeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetJokeUseCase @Inject constructor(
    private val repository: JokeRepository
) {
    operator fun invoke(): Flow<Resource<JokesDetail>> = flow {
        try {
            emit(Resource.Loading())
            val joke = repository.getJoke().toJokesDetail()
            emit(Resource.Success(joke))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}