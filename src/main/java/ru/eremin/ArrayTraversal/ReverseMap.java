package ru.eremin.ArrayTraversal;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Ограничения:
// - Необходимо создать новый Map, где ключи и значения поменяны местами.
// - Исходный Map не должен изменяться.
// - Предполагается, что значения в исходном Map уникальны.
//
// Примеры:
//
// input:
// {1="one", 2="two", 3="three"}
// output:
// {"one"=1, "two"=2, "three"=3}
//
// input:
// {"a"=100, "b"=200}
// output:
// {100="a", 200="b"}
//
// input:
// {"java"="backend", "sql"="database"}
// output:
// {"backend"="java", "database"="sql"}

public class ReverseMap {
    public static void main(String[] args) {
        Map<Integer, String> source = Map.of(1, "one", 2, "two", 3, "three");
        Map<String, Integer> reversed = reverse(source);

    }

    public static <K, V> Map<V, K> reverse(Map<K, V> source) {
//        Map<V, K> result = new HashMap<>();
//        for (Map.Entry<K, V> entry : source.entrySet()) {
//            result.put(entry.getValue(), entry.getKey());
//        }
//        return result;

        return source.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getValue,
                Map.Entry::getKey,
                (a, b) -> a,
                LinkedHashMap::new));
    }
}
