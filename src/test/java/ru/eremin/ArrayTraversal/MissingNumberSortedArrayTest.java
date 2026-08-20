package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberSortedArrayTest {

    @Test
    void shouldReturnCorrectMissingNumber() {
        int[] input = new int[]{0, 1, 2, 4, 5};

        int actual = MissingNumberSortedArray.findMissing(input);
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectMissingNumber2() {
        int[] input = new int[]{1, 2, 3, 4};

        int actual = MissingNumberSortedArray.findMissing(input);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectMissingNumber3() {
        int[] input = new int[]{0, 0, 1, 1, 2, 2, 4};

        int actual = MissingNumberSortedArray.findMissing(input);
        int expected = 3;

        assertEquals(expected, actual);
    }
}
