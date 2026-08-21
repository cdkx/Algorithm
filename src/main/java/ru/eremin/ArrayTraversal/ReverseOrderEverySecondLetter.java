package ru.eremin.ArrayTraversal;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseOrderEverySecondLetter {
    public static String reverseOrderEverySecondLetter(String input) {

        return IntStream.range(0, input.length())
                .filter(x -> x % 2 != 0)
                .mapToObj(i -> String.valueOf(input.charAt(input.length() - 1 - i)))
                .collect(Collectors.joining());

    }
}
