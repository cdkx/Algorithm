package ru.eremin.ArrayTraversal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

// Ограничения:
// - Необходимо вывести числа, которые встречаются только в одном из двух массивов.
// - Повторы внутри массива не должны влиять на результат (важен факт наличия элемента).
// - Результат может быть в любом порядке.
//
// Примеры:
//
// input:
// arr1 = [1, 2, 3, 4]
// arr2 = [3, 4, 5, 6]
// output:
// [1, 2, 5, 6]
//
// input:
// arr1 = [1, 1, 2]
// arr2 = [2, 3, 3]
// output:
// [1, 3]
//
// input:
// arr1 = [7, 8]
// arr2 = [7, 8]
// output:
// []

public class SymmetricDifferenceArrays {

    public static void main(String[] args) {
        System.out.println(findOnlyInOne(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6}));
    }

    public static List<Integer> findOnlyInOne(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : arr1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : arr2) {
            set2.add(i);
        }
        Set<Integer> copy1 = new HashSet<>(set1);
        Set<Integer> copy2 = new HashSet<>(set2);

        copy1.removeAll(set2);
        copy2.removeAll(set1);

        return Stream.concat(copy1.stream(), copy2.stream()).toList();
    }
}
