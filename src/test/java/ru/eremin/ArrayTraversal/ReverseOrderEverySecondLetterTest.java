package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseOrderEverySecondLetterTest {
    @Test
    void shouldReturnReversedStringEverySecondLetter() {
        String input = "Spring Boot!";

        String expected = "to nrS";
        String actual = ReverseOrderEverySecondLetter.reverseOrderEverySecondLetter(input);

        assertEquals(expected, actual);
    }
}
