package com.geekstudio.composetest.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun snackBar(lifecycleScope: CoroutineScope) {
    val scaffoldState = rememberScaffoldState()
    var textState by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            TextField(value = textState, onValueChange = { textValue -> textState = textValue})
            Spacer(modifier = Modifier.size(12.dp))
            Button(onClick = {
                lifecycleScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("textState : $textState")
                }
            }){
                Text(text = "Show SnackBar")
            }
        }
    }
}