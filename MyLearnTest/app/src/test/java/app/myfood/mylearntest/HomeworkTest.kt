package app.myfood.mylearntest

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class HomeworkTest {

    @Test
    fun `check if the braces are set correctly`() {
        val result = Homework.checkBraces("(()")
        assertThat(result).isFalse()
    }

    @Test
    fun `return true if the braces are set correctly`() {
        val result = Homework.checkBraces("(())")
        assertThat(result).isTrue()
    }
}