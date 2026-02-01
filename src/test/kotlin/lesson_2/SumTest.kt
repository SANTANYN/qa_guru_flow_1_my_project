package lesson_2

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("just some tests")
@Story("study tests")
@Tags(Tag("regression"),
    Tag("Check if person is adult"),
    Tag("Check if generated number is lucky"))
class SomeTestClass {


    @Test
    @DisplayName("Check if person is adult")
    fun testIsAdult() {
        val age = (0..100).random()
        val adultAge = 18

        val isAdult = age >= adultAge


        isAdult shouldBe (age >= 18)
    }

    @Test
    @DisplayName("Check if generated number is lucky")
    fun testIsLuckyNumber() {
        val number = (30..80).random()

        val isLucky = number in 33..77

        isLucky shouldBe (number in 33..77)
    }

}