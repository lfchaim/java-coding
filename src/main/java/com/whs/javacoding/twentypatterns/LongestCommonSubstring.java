package com.whs.javacoding.twentypatterns;

public class LongestCommonSubstring {
    public static int longestCommonSubstring(String s1, String s2) {
        int maxLength = 0;
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abcde", "abfce")); // Output: 2 ("ab")
    }
}
