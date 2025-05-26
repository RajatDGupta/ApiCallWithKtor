package com.demo.apicallwithktor.core.common

data class UiState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    var error: String = ""
)