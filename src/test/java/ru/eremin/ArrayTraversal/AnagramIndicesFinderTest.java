package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramIndicesFinderTest {

    @Test
    void shouldReturnCorrectIndexes1() {
        String text = "cbaebabacd";
        String word = "abc";

        List<Integer> expected = List.of(0, 6);

        List<Integer> actual = AnagramIndicesFinder.findAnagrams(text, word);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectIndexes2() {
        String text = "abab";
        String word = "ab";

        List<Integer> expected = List.of(0, 1, 2);

        List<Integer> actual = AnagramIndicesFinder.findAnagrams(text, word);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectIndexes3() {
        String text = "afdzyxksldfm";
        String word = "xyz";

        List<Integer> expected = List.of(3);

        List<Integer> actual = AnagramIndicesFinder.findAnagrams(text, word);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCorrectIndexes4() {
        String text = "zyx";
        String word = "afdgzyxksldfm";

        List<Integer> expected = Collections.emptyList();

        List<Integer> actual = AnagramIndicesFinder.findAnagrams(text, word);

        assertEquals(expected, actual);
    }
}
