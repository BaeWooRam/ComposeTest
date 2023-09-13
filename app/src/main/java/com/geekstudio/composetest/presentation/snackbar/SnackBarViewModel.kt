package com.geekstudio.composetest.presentation.snackbar


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geekstudio.composetest.data.api.RssApi
import com.geekstudio.composetest.data.remote.RssDataSource
import com.geekstudio.composetest.presentation.base.BaseUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SnackBarViewModel @Inject constructor(
    private val rssDataSource: RssDataSource
) : ViewModel() {
    private val _uiSharedFlow = MutableSharedFlow<BaseUiState>(
        replay = 10,
        extraBufferCapacity = 20,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val uiSharedFlow = _uiSharedFlow.asSharedFlow()

    /**
     *
     */
    fun loadNewsRss() {
        viewModelScope.launch {
            _uiSharedFlow.tryEmit(BaseUiState.Loading)
            rssDataSource.getNewsRss.execute(RssApi.LanguageType.KR).collect {
                _uiSharedFlow.tryEmit(BaseUiState.Success(it))
            }
        }
    }

}