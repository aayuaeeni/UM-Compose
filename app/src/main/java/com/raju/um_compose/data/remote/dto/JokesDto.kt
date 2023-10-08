package com.raju.um_compose.data.remote.dto
import com.google.gson.annotations.SerializedName
import com.raju.um_compose.domain.model.JokesDetail

data class JokesDto(
    @SerializedName("joke")
    val joke: String
)
fun JokesDto.toJokesDetail(): JokesDetail {
    return JokesDetail(joke=joke)
}