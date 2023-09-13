package com.geekstudio.composetest.data.remote.fake

import com.geekstudio.composetest.data.api.RssApi
import com.geekstudio.composetest.data.dto.Channel
import com.geekstudio.composetest.data.dto.Item
import com.geekstudio.composetest.data.dto.Rss
import com.geekstudio.composetest.utils.Util
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jetbrains.annotations.TestOnly
import java.util.Date

class FakeGetNewsRss {
    /**
     * 언어 타입에 따라 RSS 들고 오기
     */
    fun execute(languageType: RssApi.LanguageType): Flow<Rss> {
        return flow {
            val item = when (languageType) {
                RssApi.LanguageType.EN -> {
                    Rss(
                        version = "testVersion",
                        Channel(
                            arrayListOf(
                                Item(
                                    title = "news1",
                                    description = "naver news content1",
                                    pubDate = "2023-09-12",
                                    "https://naver.com"
                                ),
                                Item(
                                    title = "news2",
                                    description = "daum news content1",
                                    pubDate = "2023-09-13",
                                    "https://daum.net"
                                ),
                                Item(
                                    title = "news3",
                                    description = "google news content1",
                                    pubDate = "2023-09-14",
                                    "https://www.google.co.kr/?hl=ko"
                                ),
                                Item(
                                    title = "news4",
                                    description = "nateOn news content1",
                                    pubDate = "2023-09-15",
                                    "https://nateonweb.nate.com/"
                                ),
                                Item(
                                    title = "news5",
                                    description = "kakao news content1",
                                    pubDate = "2023-09-16",
                                    "https://www.kakaocorp.com/page/"
                                ),
                            ), lastBuildDate = "2023-09-12"
                        )
                    )
                }
                RssApi.LanguageType.KR -> {
                    Rss(
                        version = "testVersion",
                        Channel(
                            arrayListOf(
                                Item(
                                    title = "뉴스1",
                                    description = "네이버 뉴스 내용1",
                                    pubDate = "2023-09-12",
                                    "https://naver.com"
                                ),
                                Item(
                                    title = "뉴스2",
                                    description = "다음 뉴스 내용2",
                                    pubDate = "2023-09-13",
                                    "https://daum.net"
                                ),
                                Item(
                                    title = "뉴스3",
                                    description = "구글 뉴스 내용3",
                                    pubDate = "2023-09-14",
                                    "https://www.google.co.kr/?hl=ko"
                                ),
                                Item(
                                    title = "뉴스4",
                                    description = "네이트온 뉴스 내용4",
                                    pubDate = "2023-09-15",
                                    "https://nateonweb.nate.com/"
                                ),
                                Item(
                                    title = "뉴스5",
                                    description = "카카오 뉴스 내용5",
                                    pubDate = "2023-09-16",
                                    "https://www.kakaocorp.com/page/"
                                ),
                            ), lastBuildDate = "2023-09-12"
                        )
                    )
                }
            }

            emit(item)
        }
    }
}

