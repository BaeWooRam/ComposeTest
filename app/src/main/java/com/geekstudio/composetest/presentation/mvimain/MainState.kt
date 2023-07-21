package com.geekstudio.composetest.presentation.mvimain

import com.geekstudio.composetest.data.dto.Rss
import com.geekstudio.composetest.presentation.base.BaseState

data class MainState(
    override val exception: Exception? = null,
    override val loading: Boolean = true,
    val rss: Rss? = null
):BaseState

