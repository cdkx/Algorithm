package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @Test
    void shouldReturnCorrectElements() {
        int[] expected = new int[]{0, 1};

        int[] actual = TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectElements2() {
        int[] expected = new int[]{1, 2};

        int[] actual = TwoSum.twoSum(new int[]{3, 2, 4}, 6);

        assertArrayEquals(expected, actual);
    }
}
