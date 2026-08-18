package ru.eremin.ArrayTraversal;

import java.util.LinkedHashMap;
import java.util.Map;

// Ограничения:
// - Необходимо найти первый символ, который встречается в строке только один раз.
// - Регистр символов имеет значение (A ≠ a).
// - Если уникального символа нет — вернуть null.
//
// Примеры:
//
// input:
// "programming"
// output:
// 'p'
//
// input:
// "aabbcc"
// output:
// null
//
// input:
// "swiss"
// output:
// 'w'

public class FirstUniqueCharacter {

    public static void main(String[] args) {

        // ваш код здесь

    }

    public static Character findFirstUnique(String text) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : text.toCharArray()) {
            map.merge(ch, 1, Integer::sum);

        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }

        }
        return null;

    }
}
