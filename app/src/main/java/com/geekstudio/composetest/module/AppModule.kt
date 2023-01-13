package com.geekstudio.composetest.module

import com.geekstudio.composetest.data.api.ApiBuilder
import com.geekstudio.composetest.data.api.RssApi
import com.geekstudio.composetest.data.remote.RssDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRssApi(): RssApi{
        return ApiBuilder().build(RssApi.RSS_BASE, RssApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataSource(rssApi: RssApi): RssDataSource{
        return RssDataSource(rssApi)
    }
}