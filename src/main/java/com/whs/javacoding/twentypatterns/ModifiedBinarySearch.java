package com.whs.javacoding.twentypatterns;

public class ModifiedBinarySearch {
    public static int searchCeiling(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 15};
        System.out.println(searchCeiling(arr, 9)); // Output: 3 (10)
    }
}
