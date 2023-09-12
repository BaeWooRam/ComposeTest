package com.geekstudio.composetest.data.remote.fake

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.geekstudio.composetest.data.api.RssApi
import com.geekstudio.composetest.data.remote.GetNewsRss
import com.geekstudio.composetest.data.remote.RssDataSource
import com.geekstudio.composetest.presentation.main.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*


class FakeGetNewsRssTest {
    private val fakeRssDataSource = FakeRssDataSource()

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
    fun `FakeGetNewsRss_테스트`() = runBlocking{
        fakeRssDataSource.getNewsRss.execute(RssApi.LanguageType.KR).collect {
            println("FakeGetNewsRss_테스트 rss = $it")
            println("FakeGetNewsRss_테스트 channel = ${it.channel}")

            Assert.assertNotNull(it.channel)
            Assert.assertTrue(it.channel!!.item.size == 5)

            //TODO 비지니스 로직 테스트
        }
    }

}