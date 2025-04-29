package com.whs.javacoding.twentypatterns;

import java.util.Arrays;

public class TwoPointers {
    public static boolean pairWithTargetSum(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        System.out.println(pairWithTargetSum(arr, 6)); // Output: true (2 + 4)
    }
}
