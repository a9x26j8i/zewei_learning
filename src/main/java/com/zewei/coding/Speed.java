package com.zewei.coding;

import com.zewei.utils.SingleTimer;

public class Speed {
    public static void main(String[] args) {
        SingleTimer timer = SingleTimer.getInstance();
        int n = 43;
        timer.start();
        Integer[] results = new Integer[n + 1];
        slowFib(n);
        System.out.println(timer.lap());
        fib(n, results);
        System.out.println(timer.lap());


    }

    private static int slowFib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return slowFib(n - 1) + slowFib(n - 2);
        }
    }

    private static int fib(int n, Integer[] results) {
        if (results[n] != null) {
            return results[n];
        }

        if (n == 0 || n == 1) {
            results[n] = 1;
            return results[n];
        }
        //n >= 2

        results[n] = fib(n - 1, results) + fib(n - 2, results);
        return results[n];
    }
}
