package ru.eremin.ArrayTraversal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Ограничения:
// - Необходимо найти первый элемент, который встречается только один раз.
// - Порядок элементов должен сохраняться.
// - Если уникальный элемент отсутствует — вернуть null.
//
// Примеры:
//
// input:
// [4, 5, 1, 2, 0, 4, 1, 2]
// output:
// 5
//
// input:
// [7, 7, 3, 3, 9]
// output:
// 9
//
// input:
// [1, 1, 2, 2, 3, 3]
// output:
// null


public class FirstUniqueElement {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 5, 1, 2, 0, 4, 1, 2);
    }

    public static Integer findFirstUnique(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (Integer number : numbers) {
            // map.put(number, map.getOrDefault(number, 0) + 1);

            /*
             * Если нет ключа, то добавляем ключ и newValue.
             * Если есть ключ, то обновляем oldValue с помощью функции и newValue
             */
            map.merge(number, 1, Integer::sum); // функция - то что мы делаем со старым и новым значением (Value)
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
