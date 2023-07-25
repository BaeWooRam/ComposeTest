package com.geekstudio.composetest.presentation.mvimain


import com.geekstudio.composetest.data.api.RssApi
import com.geekstudio.composetest.data.remote.RssDataSource
import com.geekstudio.composetest.presentation.base.MviViewModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class MviMainViewModel @Inject constructor(
    private val rssDataSource: RssDataSource
):MviViewModel() {
    private val events = Channel<MviMainEvent>()

    // State Reducer
    override val state = events.receiveAsFlow()
        .runningFold(MviMainState(), ::reduceState)
        .stateIn(viewModelScope, SharingStarted.Eagerly, MviMainState())

    override suspend fun onEvent(event: MviMainEvent) {
        events.send(event)
    }

    private fun reduceState(current: MviMainState, event: MviMainEvent): MviMainState {
        return when (event) {
            is MviMainEvent.UpdateRss -> current.copy(rss = event.rss, isLoading = false)
            is MviMainEvent.Loading -> current.copy(rss = null, isLoading = true)
        }
    }

    /**
     *
     */
    fun loadNewsRss(){
        viewModelScope.launch {
            events.send(MviMainEvent.Loading)

            rssDataSource.getNewsRss.execute(RssApi.LanguageType.KR).collect{
                events.send(MviMainEvent.UpdateRss(it))
            }
        }
    }
}