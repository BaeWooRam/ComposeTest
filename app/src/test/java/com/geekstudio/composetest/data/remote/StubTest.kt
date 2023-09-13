package com.geekstudio.composetest.data.remote

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class StubTest {
    private lateinit var person: StubPerson

    class StubPerson : Mockito1Test.Person {
        override fun eat(): Mockito1Test.Person.EatResult {
            return Mockito1Test.Person.EatResult.Hungry
        }

        override fun sleep(): Mockito1Test.Person.SleepResult {
            return Mockito1Test.Person.SleepResult.Tired
        }

        override fun randomPlay(): Mockito1Test.Person.PlayResult {
            return Mockito1Test.Person.PlayResult.Game
        }
    }

    @Before
    fun setUp() {
        person = StubPerson()
    }

    @Test
    fun `Stub_기본테스트`() {
        val resultPlay = person.randomPlay()
        val resultSleep = person.sleep()
        val resultEat = person.eat()
        println("Stub_기본테스트 randomPlay = $resultPlay")
        println("Stub_기본테스트 sleep = $resultSleep")
        println("Stub_기본테스트 eat = $resultEat")

        Assert.assertSame(resultPlay, Mockito1Test.Person.PlayResult.Game)
        Assert.assertSame(resultSleep, Mockito1Test.Person.SleepResult.Tired)
        Assert.assertSame(resultEat, Mockito1Test.Person.EatResult.Hungry)

        //TODO 비지니스 로직 테스트 진행
    }
}