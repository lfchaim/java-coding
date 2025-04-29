package com.whs.javacoding.twopointers;

import java.util.*;

public class PairWithTargetSum {
    public static int[] findPair(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return new int[]{left, right};
            if (sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPair(new int[]{1, 2, 3, 4, 6}, 6))); // Output: [1, 3]
    }
}
