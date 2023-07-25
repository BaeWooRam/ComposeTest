package com.geekstudio.composetest.presentation.base

interface MviBaseState{
    val loading: Boolean?
    val exception: Exception?
}