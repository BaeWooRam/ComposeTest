package com.geekstudio.composetest.data.remote

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DummyTest {
    private lateinit var computer: Computer

    interface Computer {
        fun input()
        fun output()
    }

    @Before
    fun setUp() {
        computer = object : Computer {
            override fun input() {
            }

            override fun output() {
            }
        }
    }

    @Test
    fun `Stub_기본테스트`() {
        computer.output()
        computer.input()

        //TODO 비지니스 로직 테스트 진행
    }
}