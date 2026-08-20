package ru.eremin.ArrayTraversal;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseMapTest {

    @Test
    void shouldReturnReversedMap() {
        var source = Map.of(1, "one", 2, "two", 3, "three");
        var expected = Map.of("one", 1, "two", 2, "three", 3);

        var actual = ReverseMap.reverse(source);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnReversedMap2() {
        var source = Map.of("a", 100, "b", 200);
        var expected = Map.of(100, "a", 200, "b");

        var actual = ReverseMap.reverse(source);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnReversedMap3() {
        var source = Map.of("java", "backend", "sql", "database");
        var expected = Map.of("backend", "java", "database", "sql");

        var actual = ReverseMap.reverse(source);

        assertEquals(expected, actual);
    }
}
