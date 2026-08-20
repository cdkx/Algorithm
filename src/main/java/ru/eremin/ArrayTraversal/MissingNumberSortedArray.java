package ru.eremin.ArrayTraversal;

// Ограничения:
// - Дан отсортированный массив целых неотрицательных чисел.
// - В массиве допускаются дубликаты.
// - Необходимо найти минимальное пропущенное число в последовательности.
// - Возвращаемое значение — первое "разрывное" число.
//
// Примеры:
//
// input:
// [0, 1, 2, 4, 5]
// output:
// 3
//
// input:
// [1, 2, 3, 4]
// output:
// 0
//
// input:
// [0, 0, 1, 1, 2, 2, 4]
// output:
// 3

public class MissingNumberSortedArray {

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 2, 4, 5};
        int actual = findMissing(input);
    }

    public static int findMissing(int[] arr) {
        if (arr[0] != 0) {
            return 0;
        }

        int expected = 0;
        for (int i = 0; i < arr.length; i++) {

            if (expected == arr[i]) {
                expected++;

            } else if (expected < arr[i]) {
                return expected;
            }
        }

        return -1;
    }
}