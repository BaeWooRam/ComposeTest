package com.geekstudio.composetest.presentation.base

sealed class BaseUiState{
    object Loading: BaseUiState()
    data class Success<T>(val data: T): BaseUiState()
    data class Error(val error: Throwable?): BaseUiState()
}