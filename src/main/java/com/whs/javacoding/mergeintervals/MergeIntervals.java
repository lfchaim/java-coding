package com.whs.javacoding.mergeintervals;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);
        for (int[] interval : intervals) {
            if (interval[0] <= current[1])
                current[1] = Math.max(current[1], interval[1]);
            else {
                current = interval;
                merged.add(current);
            }
        }
        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(input))); // Output: [[1, 6], [8, 10], [15, 18]]
    }
}
