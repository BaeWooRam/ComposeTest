package com.geekstudio.composetest.data.remote

import com.geekstudio.composetest.data.api.ApiBuilder
import com.geekstudio.composetest.data.api.RssApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetNewsRssTest {
    private val api = ApiBuilder.build(RssApi.RSS_BASE, RssApi::class.java)

    @Test
    fun `기본_동작_테스트_getAll`() {
        CoroutineScope(Dispatchers.IO).run {
            runBlocking {
                GetNewsRss(api).getAll(RssApi.LanguageType.KR).collect { rss ->
                    Assert.assertNotNull(rss)
                    Assert.assertNotNull(rss.channel)
                    Assert.assertFalse(rss.channel.item.isEmpty())
                    println("기본_동작_테스트_getAll rss = $rss")
                }
            }
        }
    }
}