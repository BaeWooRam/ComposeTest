package com.geekstudio.composetest.presentation.mvimain

import com.geekstudio.composetest.data.dto.Rss

data class MviMainState(
    var rss: Rss? = null,
    val isLoading: Boolean? = null,
)