package lesson_4

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

data class UserInput(
    val name: String?,
    val age: Int?,
    val email: String?
)

data class UserFilled(
    val name: String,
    val age: Int,
    val email: String
)

fun fillNulls(input: UserInput): UserFilled {
    val name = input.name ?: run {
        println("Параметр 'name' не передан, заменить на: ''")
        ""
    }
    val age = input.age ?: run {
        println("Параметр 'age' wне передан, заменить на 0")
        0
    }
    val email = input.email ?: run {
        println("Параметр 'email' не передан, заменить на: ''")
        ""
    }
    return UserFilled(name = name, age = age, email = email)
}

class Lesson4Homework {

    @Test
    @DisplayName("Все поля null, подставляются дефолты")
    fun `all nulls filled with defaults`() {
        val input = UserInput(name = null, age = null, email = null)
        val result = fillNulls(input)
        result.name shouldBe ""
        result.age shouldBe 0
        result.email shouldBe ""
    }

    @Test
    @DisplayName("Частично null, подменяется только null")
    fun `partial nulls only substituted`() {
        val input = UserInput(name = "Alice", age = null, email = "test@test.com")
        val result = fillNulls(input)
        result.name shouldBe "Alice"
        result.age shouldBe 0
        result.email shouldBe "test@test.com"
    }

    @Test
    @DisplayName("Без null, значения не меняются")
    fun `no nulls values unchanged`() {
        val input = UserInput(name = "test", age = 33, email = "test@test.com")
        val result = fillNulls(input)
        result.name shouldBe "test"
        result.age shouldBe 33
        result.email shouldBe "test@test.com"
    }
}
