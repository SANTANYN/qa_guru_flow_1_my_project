package lesson_3_base_syntax

import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldContain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldBeSortedWith


class Lesson3Homework {

    @Test
    @DisplayName("Проверка что массив пустой")
    fun `empty array should be empty`() {
        val emptyArray = emptyArray<String>()
        emptyArray.isEmpty() shouldBe true
        // array нельзя проверить через shouldbeempty - так что преобразую.
        emptyArray.toList().shouldBeEmpty()
    }

    @Test
    @DisplayName("Проверка что массив не пустой")
    fun `empty array should be not empty`() {
        val notEmptyArray = arrayOf("test1", "test_value_2")
        notEmptyArray.isNotEmpty() shouldBe true
    }

    @Test
    @DisplayName("Проверки списка")
    fun `checks for array of string`() {
        val someArray = arrayOf("correct_test_value", "test_value_2", "test_value_3")
        someArray[0] shouldBe "correct_test_value"
        someArray.shouldContain("correct_test_value")
        someArray.toList() shouldContainExactly listOf("correct_test_value", "test_value_2", "test_value_3")
    }

    @Test
    @DisplayName("Проверка списка чисел")
    fun `checks for array of integers`() {
        val someIntArray = arrayOf(1, 2, 3, 4, 5)
        someIntArray.toList().shouldBeSorted()
        someIntArray.shouldBeSortedWith(naturalOrder())
    }
}
