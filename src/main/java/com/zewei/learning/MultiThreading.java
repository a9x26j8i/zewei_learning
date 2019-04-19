package com.zewei.learning;

import java.util.Scanner;

public class MultiThreading implements Runnable{

    public static void main(String[] args) {
        q1();
    }

    private static void q1(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;

        if (n < 1) {
            result = 0;
            System.out.print(result);
            return;
        } else if (n == 1) {
            result = 1;
            System.out.print(result);
            return;
        }

        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        result = dp[n];

        System.out.print(result);
    }
    @Override
    public void run(){
        System.out.println("This is my thread.");
    }

}
