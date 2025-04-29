package com.whs.javacoding.twentypatterns;

import java.util.*;

public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findSubsets(new int[]{1, 2, 3}));
        // Output: [[], [1], [1, 2], [1, 2, 3], ...]
    }
}
