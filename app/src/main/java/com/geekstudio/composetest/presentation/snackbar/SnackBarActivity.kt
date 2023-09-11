package com.geekstudio.composetest.presentation.snackbar

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.geekstudio.composetest.data.dto.Rss
import com.geekstudio.composetest.presentation.base.BaseActivity
import com.geekstudio.composetest.presentation.base.BaseUiState
import com.geekstudio.composetest.ui.theme.ComposeTestTheme
import com.geekstudio.composetest.ui.view.RssList
import com.geekstudio.composetest.ui.view.snackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SnackBarActivity : BaseActivity() {
    private val viewModel: SnackBarViewModel by viewModels()
    private val titleState = mutableStateOf("")
    private val valueState = mutableStateOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initUiObserver()
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadNewsRss()
    }

    private fun initUiObserver(){
        repeatOnStarted{
            viewModel.uiSharedFlow.collect{
                when(it){
                    is BaseUiState.Success<*> -> {

                    }
                    is BaseUiState.Loading -> {
                        Log.d("initUiObserver", "loading")
                        titleState.value = "Loading Title"
                        valueState.value = "Loading Value"
                    }
                    is BaseUiState.Error -> {
                        Log.d("initUiObserver", "Error = ${it.error}")
                        titleState.value = "Error Title"
                        valueState.value = "Error Value"
                    }
                }
            }
        }
    }

    private fun initView(){
        setContent {
            ComposeTestTheme {
                snackBar()
            }
        }
    }
}

