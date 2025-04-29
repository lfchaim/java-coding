package com.whs.javacoding.twentypatterns;

import java.util.*;

public class TopKElements {
    public static List<Integer> findTopK(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 12, 2, 11};
        System.out.println(findTopK(nums, 3)); // Output: [5, 11, 12]
    }
}
