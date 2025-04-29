package com.whs.javacoding.cyclicsort;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            } else i++;
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i) return i;
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{4, 0, 3, 1})); // Output: 2
    }
}
