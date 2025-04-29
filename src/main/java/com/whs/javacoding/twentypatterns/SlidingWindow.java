package com.whs.javacoding.twentypatterns;

public class SlidingWindow {
    public static int maxSubArraySum(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // adicionar o próximo elemento
            
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // remover o elemento que sai da janela
                windowStart++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSubArraySum(arr, 3)); // Output: 9
    }
}