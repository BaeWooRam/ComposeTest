package com.geekstudio.composetest.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.geekstudio.composetest.data.api.ApiBuilder
import com.geekstudio.composetest.data.api.RssApi
import com.geekstudio.composetest.presentation.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

class GetNewsRssTest {
    private val api = ApiBuilder().build(RssApi.RSS_BASE, RssApi::class.java)
    private val mainViewModel = MainViewModel(RssDataSource(api))

    // LiveData 이용을 위한 처리 - core-testing 함께 사용
    @get:Rule
    val rule = InstantTaskExecutorRule()

    //Coroutine Dispatcher 설정
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        // Dispatcher 상태를 Unconfined으로 변경
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    //Coroutine Dispatcher Reset
    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `기본_동작_테스트_getAll`() = runBlocking{
        GetNewsRss(api).execute(RssApi.LanguageType.KR).collect { rss ->
            Assert.assertNotNull(rss)
            Assert.assertNotNull(rss.channel)
            Assert.assertFalse(rss.channel!!.item.isEmpty())
            println("기본_동작_테스트_getAll rss = $rss")
        }
    }

    @Test
    fun `기본_동작_테스트_MainViewModel`() = runBlocking{
        mainViewModel.loadNewsRss()
        println("기본_동작_테스트_MainViewModel")
    }
}