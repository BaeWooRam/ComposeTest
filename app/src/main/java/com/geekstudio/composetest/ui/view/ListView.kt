package com.geekstudio.composetest.ui.view

import android.text.Html
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.geekstudio.composetest.data.dto.Item
import com.geekstudio.composetest.data.dto.Rss
import com.geekstudio.composetest.ui.theme.ComposeTestTheme
import com.geekstudio.composetest.ui.theme.DefaultMargin
import com.geekstudio.composetest.utils.Util

@Composable
fun RssList(rss: Rss) {
    val channel = rss.channel
    LazyColumn() {
        itemsIndexed(
            channel.item
        ) { index, item ->
            ItemCard(item)
        }
    }
}

@Composable
private fun ItemCard(item: Item){
    Column {
        Text(text = Util.decodingHtml(item.title))
        Text(text = Util.decodingHtml(item.description))
    }
}
