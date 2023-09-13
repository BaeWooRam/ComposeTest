package com.geekstudio.composetest.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview
@Composable
fun snackBar() {
    val scaffoldState = rememberScaffoldState()
    var textState by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            TextField(
                value = textState,
                onValueChange = { textValue -> textState = textValue },
                Modifier.testTag("SnackTextField")
            )
            Spacer(modifier = Modifier.size(12.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("textState : $textState")
                }
            }) {
                Text(text = "Show SnackBar")
            }
        }
    }
}