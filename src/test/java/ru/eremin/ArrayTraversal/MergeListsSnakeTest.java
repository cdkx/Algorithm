package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class MergeListsSnakeTest {

    @Test
    void shouldMergeCorrect() {
        List<Integer> first = List.of(1, 2, 3);
        List<Integer> second = List.of(4, 5, 6);

        List<Integer> expected = List.of(1, 4, 2, 5, 3, 6);

        List<Integer> actual = MergeListsSnake.mergeSnake(first, second);

        assertIterableEquals(expected, actual);
    }

    @Test
    void shouldMergeCorrect2() {
        List<Integer> first = List.of(1, 2, 3, 4);
        List<Integer> second = List.of(5, 6);

        List<Integer> expected = List.of(1, 5, 2, 6, 3, 4);

        List<Integer> actual = MergeListsSnake.mergeSnake(first, second);

        assertIterableEquals(expected, actual);
    }

    @Test
    void shouldMergeCorrect3() {
        List<Integer> first = List.of(1);
        List<Integer> second = List.of(2, 3, 4);

        List<Integer> expected = List.of(1, 2, 3, 4);

        List<Integer> actual = MergeListsSnake.mergeSnake(first, second);

        assertIterableEquals(expected, actual);
    }

}
