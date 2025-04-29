package com.whs.javacoding.twentypatterns;

import java.util.*;

public class Fibonacci {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if (n < 2) return n;
        if (!memo.containsKey(n)) {
            memo.put(n, fib(n - 1) + fib(n - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // Output: 55
    }
}
