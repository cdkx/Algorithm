package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymmetricDifferenceArraysTest {

    @Test
    void shouldReturnOnlyInOneElement() {
        List<Integer> expected = List.of(1, 2, 5, 6);

        List<Integer> actual = SymmetricDifferenceArrays.findOnlyInOne(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6});

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnOnlyInOneElement2() {
        List<Integer> expected = List.of(1, 3);

        List<Integer> actual = SymmetricDifferenceArrays.findOnlyInOne(new int[]{1, 1, 2}, new int[]{2, 3, 3});

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnOnlyInOneElement3() {
        List<Integer> expected = List.of();

        List<Integer> actual = SymmetricDifferenceArrays.findOnlyInOne(new int[]{7, 8}, new int[]{7, 8});

        assertEquals(expected, actual);
    }
}
