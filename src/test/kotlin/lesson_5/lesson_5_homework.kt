package lesson_5

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SomeCompanionAssert() {
    companion object {
        fun String.validatePhone(): Boolean {
            val regex = Regex(pattern = "^\\\\+\\\\d{1,3}\\\\d{9,15}")
            return regex.matches(input = this)
        }

        fun String.upperCaseAssertion(): Boolean {
            return this.isNotEmpty() && this == this.uppercase()
        }

        infix fun String.shouldPassPhone(expected: Boolean) {
            val actual = this.validatePhone()
            if (actual != expected) throw AssertionError("Phone '$this': expected $expected, got $actual")
        }

        infix fun String.shouldPassUpper(expected: Boolean) {
            val actual = this.upperCaseAssertion()
            if (actual != expected) throw AssertionError("Upper '$this': expected $expected, got $actual")
        }
    }
}


data class ProfileData(
    val phone: String,
    val statusCode: String
)

val data = ProfileData(phone = "+79991234567", statusCode = "ACTIVE")
val invalidData = ProfileData(phone = "+799912-34567", statusCode = "inACTIVE")




class Lesson5Homework {

    @Test
    @DisplayName("ПроверОчкаВалидации")
    fun proverochka() {  // метод экземпляра
        with(SomeCompanionAssert) {
            data.phone.validatePhone() shouldBe true
            data.statusCode.upperCaseAssertion() shouldBe true
            invalidData.phone.validatePhone() shouldBe false
            invalidData.statusCode.upperCaseAssertion() shouldBe false
        }
    }

    @Test
    @DisplayName("Проверка валидации через infix")
    fun proverochkaInfix() {
        with(SomeCompanionAssert) {
            data.phone shouldPassPhone true
            data.statusCode shouldPassUpper true
            invalidData.phone shouldPassPhone false
            invalidData.statusCode shouldPassUpper false
        }
    }
}

