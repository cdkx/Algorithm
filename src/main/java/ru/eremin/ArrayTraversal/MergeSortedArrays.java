package ru.eremin.ArrayTraversal;

// Ограничения:
// - Даны два отсортированных массива.
// - Необходимо объединить их в один отсортированный массив.
// - Результат должен сохранять порядок возрастания.
// - Использовать дополнительный массив для результата допустимо.
//
// Примеры:
//
// input:
// arr1 = [1, 3, 5]
// arr2 = [2, 4, 6]
// output:
// [1, 2, 3, 4, 5, 6]
//
// input:
// arr1 = [1, 2, 2]
// arr2 = [2, 3, 4]
// output:
// [1, 2, 2, 2, 3, 4]
//
// input:
// arr1 = [5, 10, 15]
// arr2 = [1, 2, 20]
// output:
// [1, 2, 5, 10, 15, 20]

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3};
        int[] input2 = new int[]{2, 4, 6};
        int[] actual = MergeSortedArrays.merge(input1, input2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int len1;
        int len2;
        int[] result = new int[arr1.length + arr2.length];

        if (arr1.length >= arr2.length) {
            len1 = arr1.length;
            len2 = arr2.length;
        } else {
            len1 = arr2.length;
            len2 = arr1.length;
        }

        int i = 0;
        int j = 0;
        int r = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                result[r] = arr1[i];
                i++;
                r++;
            } else {
                result[r] = arr2[j];
                j++;
                r++;
            }
        }

        while (j < len2) {
            result[r] = arr2[j];
            j++;
            r++;
        }

        return result;
    }
}
