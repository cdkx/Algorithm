package ru.eremin.ArrayTraversal;

// Ограничения:
// - Необходимо найти индексы двух элементов массива, сумма которых равна target.
// - Гарантируется, что решение существует и оно единственное.
// - Один элемент нельзя использовать дважды.
//
// Примеры:
//
// input:
// nums = [2, 7, 11, 15], target = 9
// output:
// [0, 1]
//
// input:
// nums = [3, 2, 4], target = 6
// output:
// [1, 2]

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] actual = twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }
}
