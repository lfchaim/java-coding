package com.whs.javacoding.twentypatterns;

public class BitwiseXOR {
    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 1, 2};
        System.out.println(findSingleNumber(nums)); // Output: 4
    }
}
