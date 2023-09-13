package com.geekstudio.composetest.presentation.base

import com.geekstudio.composetest.presentation.mvimain.MviMainEvent
import com.geekstudio.composetest.presentation.mvimain.MviMainState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.StateFlow

abstract class MviViewModel {
    internal val viewModelScope: CoroutineScope = GlobalScope
    abstract val state: StateFlow<MviMainState>
    abstract suspend fun onEvent(event: MviMainEvent)
}