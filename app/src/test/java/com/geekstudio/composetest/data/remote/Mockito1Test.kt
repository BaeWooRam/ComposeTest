package com.geekstudio.composetest.data.remote

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.stubbing.Answer

class Mockito1Test {
    private lateinit var person: Person

    /**
     * Mock 테스트용 클래스
     */
    interface Person {
        fun eat(): EatResult
        fun sleep(): SleepResult
        fun randomPlay(): PlayResult

        sealed class EatResult {
            object Fullness : EatResult()
            object Hungry : EatResult()
        }

        sealed class SleepResult {
            object VeryGood : SleepResult()
            object Tired : SleepResult()
        }

        sealed class PlayResult {
            object Game : PlayResult()
            object Singing : PlayResult()
            object Gym : PlayResult()
        }
    }

    @Before
    fun setUp() {
        person = Mockito.mock(Person::class.java)
        //thenThrow 예제
        Mockito.`when`(person.randomPlay()).thenThrow(RuntimeException())

        //thenAnswer 예제
        Mockito.`when`(person.eat()).thenAnswer(Answer<Person.EatResult> {
            println("person eat start!")
            return@Answer Person.EatResult.Fullness
        })

        //thenReturn 예제
        Mockito.`when`(person.sleep()).thenReturn(Person.SleepResult.Tired)
    }

    @Test
    fun `Mockito_예제1`() {
        val resultEat = person.eat()
        println("Mockito_예제1 resultEat = $resultEat")
        Assert.assertSame(Person.EatResult.Fullness, resultEat)

        val resultSleep = person.sleep()
        println("Mockito_예제1 resultSleep = $resultSleep")
        Assert.assertSame(Person.SleepResult.Tired, resultSleep)

        val resultRandomPlaY = person.randomPlay()
        println("Mockito_예제1 resultRandomPlaY = $resultRandomPlaY")
        Assert.assertSame(Person.PlayResult.Gym, resultRandomPlaY)
    }
}