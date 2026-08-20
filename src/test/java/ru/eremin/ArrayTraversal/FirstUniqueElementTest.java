package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FirstUniqueElementTest {
    @Test
    void shouldReturnCorrectUniqueElement() {
        Integer expected = 5;

        Integer actual = FirstUniqueElement.findFirstUnique(List.of(4, 5, 1, 2, 0, 4, 1, 2));

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectUniqueElement2() {
        Integer expected = 9;

        Integer actual = FirstUniqueElement.findFirstUnique(List.of(7, 7, 3, 3, 9));

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfNoUniqueElements() {

        Integer actual = FirstUniqueElement.findFirstUnique(List.of(1, 1, 2, 2, 3, 3));

        assertNull(actual);
    }
}
