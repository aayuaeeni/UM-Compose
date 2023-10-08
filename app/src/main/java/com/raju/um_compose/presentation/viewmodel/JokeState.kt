package com.raju.um_compose.presentation.viewmodel

import com.raju.um_compose.domain.model.JokesDetail

data class JokeState(
    val isLoading: Boolean = false,
    val jokes: List<JokesDetail> = emptyList(),
    val error: String = ""
)
