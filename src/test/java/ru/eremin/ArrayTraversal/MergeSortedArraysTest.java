package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArraysTest {

    @Test
    void shouldMergeCorrect() {
        int[] input1 = new int[]{1, 3, 5};
        int[] input2 = new int[]{2, 4, 6};

        int[] actual = MergeSortedArrays.merge(input1, input2);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMergeCorrect2() {
        int[] input1 = new int[]{1, 2, 2};
        int[] input2 = new int[]{2, 3, 4};

        int[] actual = MergeSortedArrays.merge(input1, input2);
        int[] expected = new int[]{1, 2, 2, 2, 3, 4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldMergeCorrect3() {
        int[] input1 = new int[]{5, 10, 15};
        int[] input2 = new int[]{1, 2, 20};

        int[] actual = MergeSortedArrays.merge(input1, input2);
        int[] expected = new int[]{1, 2, 5, 10, 15, 20};

        assertArrayEquals(expected, actual);
    }
}
