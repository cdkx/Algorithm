package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FirstUniqueCharacterTest {

    @Test
    void shouldReturnCorrectUniqueCharacter() {
        Character expected = 'p';

        Character actual = FirstUniqueCharacter.findFirstUnique("programming");

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNullIfCorrectUniqueCharacterDoesNotFind() {

        Character actual = FirstUniqueCharacter.findFirstUnique("aabbcc");

        assertNull(actual);
    }

    @Test
    void shouldReturnCorrectUniqueCharacter3() {
        Character expected = 'w';

        Character actual = FirstUniqueCharacter.findFirstUnique("swiss");

        assertEquals(expected, actual);
    }
}
