package com.geekstudio.composetest.data.api

import com.geekstudio.composetest.data.dto.Rss
import retrofit2.http.GET

interface RssApi {
    enum class LanguageType(private val value: Int) {
        KR(0), EN(1);

        fun getValue() = value
    }

    /**
     * 구글 한국 뉴스
     */
    @GET(RSS_KR_URL)
    suspend fun getKrNewsList(): Rss

    /**
     * 구글 미국 뉴스
     */
    @GET(RSS_EN_URL)
    suspend fun getEnNewsList(): Rss

    companion object {
        const val RSS_BASE = "https://news.google.com/"
        const val RSS_KR_URL = "rss?hl=ko&gl=KR&ceid=KR:ko"
        const val RSS_EN_URL = "rss?hl=en-US&gl=US&ceid=US:en"
    }
}