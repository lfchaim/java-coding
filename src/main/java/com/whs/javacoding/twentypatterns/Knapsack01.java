package com.whs.javacoding.twentypatterns;

public class Knapsack01 {
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = dp[i - 1][c];
                if (weights[i - 1] <= c) {
                    profit1 = profits[i - 1] + dp[i - 1][c - weights[i - 1]];
                }
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(solveKnapsack(profits, weights, 7)); // Output: 22
    }
}
