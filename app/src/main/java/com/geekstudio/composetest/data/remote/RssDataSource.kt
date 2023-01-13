package com.geekstudio.composetest.data.remote

import com.geekstudio.composetest.data.api.RssApi
import javax.inject.Inject

class RssDataSource @Inject constructor(
    private val rssApi: RssApi
) {
    val getNewsRss = GetNewsRss(rssApi)
}