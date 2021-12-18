package app.myfood.mylearntest

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Helio",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already existy returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Agostinho",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    /**
     * Password test case
     */
    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Agostinho",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password was repeated incorrectly return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Helio",
            "123",
            "1234"
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `less than 2 digit password return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Helio",
            "12",
            "12"
        )
        assertThat(result).isFalse()
    }


}