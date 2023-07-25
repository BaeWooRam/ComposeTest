package com.geekstudio.composetest.presentation.mvimain

import com.geekstudio.composetest.data.dto.Rss

sealed class MviMainEvent {
    data class UpdateRss(val rss:Rss) : MviMainEvent()
    object Loading : MviMainEvent()
}