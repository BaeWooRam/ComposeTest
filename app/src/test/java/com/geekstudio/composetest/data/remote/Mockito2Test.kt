package com.geekstudio.composetest.data.remote

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class Mockito2Test {
    private lateinit var person: Mockito1Test.Person

    @Before
    fun setUp(){
        person = Mockito.mock(Mockito1Test.Person::class.java)
        Mockito.`when`(person.randomPlay()).thenReturn(Mockito1Test.Person.PlayResult.Game)
        Mockito.`when`(person.sleep()).thenReturn(Mockito1Test.Person.SleepResult.VeryGood)
        Mockito.`when`(person.eat()).thenReturn(Mockito1Test.Person.EatResult.Hungry)

        // doThrow() 설정, person.setAge(28) 호출 시 RuntimeException 예외 발생
        Mockito.doThrow(RuntimeException())
            .`when`(person) // 협력객체(대상) 설정
            .eat()
    }

    @Test
    fun `Mockito_doThrow_테스트`() {
        println("Mockito_doThrow_테스트 randomPlay = ${person.randomPlay()}")
        println("Mockito_doThrow_테스트 sleep = ${person.sleep()}")
        println("Mockito_doThrow_테스트 eat = ${person.eat()}")
    }
}