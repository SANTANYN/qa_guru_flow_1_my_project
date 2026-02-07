package lesson_4

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


data class CatInfo(
    val name: String?,
    val age: Int?,
    val bread: String? ,
    val color: String?

)

fun fillNulls(input: CatInfo): CatInfo {
    val name = input.name ?: run {
        println("Параметр 'name' не передан, заменить на: ''")
        ""
    }
    val age = input.age ?: run {
        println("Параметр 'age' wне передан, заменить на 0")
        0
    }
    val bread = input.bread ?: run {
        println("Параметр 'bread' не передан, заменить на: ''")
        ""
    }
    val color = input.color ?: run {
        println("Параметр 'color' не передан, заменить на: ''")
        ""
    }
    return CatInfo(name = name, age = age, bread = bread, color = color )
}


class Lesson4HomeworkWithOneClass {

    @Test
    @DisplayName("Все поля null, подставляются дефолты")
    fun `all nulls filled with defaults`() {
        val input = CatInfo(name = null, age = null, bread = null, color = null)
        val result = fillNulls(input)
        result.name shouldBe ""
        result.age shouldBe 0
        result.bread shouldBe ""
        result.color shouldBe ""
    }
    @Test
    @DisplayName("Частично null, подменяется только null")
    fun `partial nulls only substituted`() {
        val input = CatInfo(name = "kotec", age = null, bread = "street", color = null)
        val result = fillNulls(input)
        result.name shouldBe "kotec"
        result.age shouldBe 0
        result.bread shouldBe "street"
        result.color shouldBe ""
    }

    @Test
    @DisplayName("Без null, значения не меняются")
    fun `no nulls values unchanged`() {
        val input = CatInfo(name = "kotec", age = 3, bread = "street", color = "black")
        val result = fillNulls(input)
        result.name shouldBe "kotec"
        result.age shouldBe 3
        result.bread shouldBe "street"
        result.color shouldBe "black"
    }
}