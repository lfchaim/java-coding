package com.whs.javacoding.twentypatterns;

import java.util.Arrays;

public class CyclicSort {
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 4, 2};
        sort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 2, 3, 4, 5]
    }
}
