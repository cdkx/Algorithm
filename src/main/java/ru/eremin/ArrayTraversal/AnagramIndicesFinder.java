package ru.eremin.ArrayTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ограничения:
// - Необходимо найти все начальные индексы подстрок в text, которые являются анаграммами слова word.
// - Анаграмма — это перестановка символов слова.
// - Подстрока должна иметь длину, равную длине word.
// - Результат возвращается как список индексов.
//
// Примеры:
//
// input:
// text = "cbaebabacd", word = "abc"
// output:
// [0, 6]
//
// input:
// text = "abab", word = "ab"
// output:
// [0, 1, 2]
//
// input:
// text = "afdzyxksldfm", word = "xyz"
// output:
// [3]

public class AnagramIndicesFinder {

    public static void main(String[] args) {
        String text = "abab";
        String word = "ab";
        List<Integer> actual = findAnagrams(text, word);
    }

    public static List<Integer> findAnagrams(String text, String word) {
        if (text.length() < word.length()) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();

        int[] targetCount = new int[26];
        int[] currentWindowCount = new int[26];

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            targetCount[index]++;
        }

        int windowLength = word.length();
        for (int i = 0; i < windowLength; i++) {
            int index = text.charAt(i) - 'a';
            currentWindowCount[index]++;
        }

        if (isEquals(targetCount, currentWindowCount)) {
            result.add(0);
        }

        for (int i = 1; i <= text.length() - word.length(); i++) {
            char leftChar = text.charAt(i - 1);
            int indexLeftChar = leftChar - 'a';
            currentWindowCount[indexLeftChar]--;

            char newChar = text.charAt(i + word.length() - 1);
            int indexNewChar = newChar - 'a';
            currentWindowCount[indexNewChar]++;


            if (isEquals(targetCount, currentWindowCount)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isEquals(int[] targetCount, int[] currentWindowCount) {
        boolean isEquals = true;
        for (int i = 0; i < 26; i++) {
            if (targetCount[i] != currentWindowCount[i]) {
                isEquals = false;
                break;
            }
        }
        return isEquals;
    }
}
