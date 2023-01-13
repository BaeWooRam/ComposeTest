package com.geekstudio.composetest.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.geekstudio.composetest.data.dto.Rss
import com.geekstudio.composetest.presentation.base.BaseActivity
import com.geekstudio.composetest.presentation.base.BaseUiState
import com.geekstudio.composetest.ui.theme.ComposeTestTheme
import com.geekstudio.composetest.ui.view.Greeting
import com.geekstudio.composetest.ui.view.RssList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUiObserver()
        viewModel.loadNewsRss()
    }

    private fun initUiObserver(){
        repeatOnStarted{
            viewModel.uiSharedFlow.collect{
                when(it){
                    is BaseUiState.Success<*> -> {
                        when(it.data){
                            is Rss -> {
                                Log.d("initUiObserver", "data = ${it.data}")
                                initView(it.data)
                            }

                            else -> {

                            }
                        }
                    }
                    is BaseUiState.Loading -> {}
                    is BaseUiState.Error -> {}
                }
            }
        }
    }

    private fun initView(rss: Rss){
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RssList(rss)
                }
            }
        }
    }
}

