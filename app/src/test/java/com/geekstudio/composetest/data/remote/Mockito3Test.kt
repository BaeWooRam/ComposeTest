package com.geekstudio.composetest.data.remote

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class Mockito3Test {
    private lateinit var person: Mockito1Test.Person

    @Before
    fun setUp() {
        person = Mockito.mock(Mockito1Test.Person::class.java)
        //호출 순서에 따라 반환 값 설정
        Mockito.`when`(person.sleep())
            .thenReturn(Mockito1Test.Person.SleepResult.VeryGood)    // 첫번째 반환 값 설정
            .thenReturn(Mockito1Test.Person.SleepResult.Tired)    // 첫번째 반환 값 설정
            .thenThrow(RuntimeException())                        // 두번째 반환 값 설정
    }

    @Test
    fun `Mockito_반환값_순서_테스트`() {
        println("Mockito_반환값_순서_테스트 result1 = ${person.sleep()}")
        println("Mockito_반환값_순서_테스트 result2 = ${person.sleep()}")
        println("Mockito_반환값_순서_테스트 result3 = ${person.sleep()}")
    }
}