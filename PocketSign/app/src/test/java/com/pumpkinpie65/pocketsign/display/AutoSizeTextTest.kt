package com.pumpkinpie65.pocketsign.display

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AutoSizeTextTest {
    @Test
    fun wrapsInsideWord_whenLineEndsMidWord() {
        assertTrue(wrapsInsideWord("HELLO", listOf(3)))
    }

    @Test
    fun wrapsInsideWord_whenLineEndsAtSpace() {
        assertFalse(wrapsInsideWord("hello world", listOf(6)))
        assertFalse(wrapsInsideWord("hello world", listOf(5)))
    }

    @Test
    fun wrapsInsideWord_whenLineEndsAtNewline() {
        assertFalse(wrapsInsideWord("hello\nworld", listOf(5)))
    }

    @Test
    fun wrapsInsideWord_ignoresEndOfText() {
        assertFalse(wrapsInsideWord("hello", listOf(5)))
    }
}
