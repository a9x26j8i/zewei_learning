package com.zewei.coding;

public class TilingProblem {
    public static void main(String[] args) {
        TilingProblem s = new TilingProblem();

        System.out.println(s.tiling(4));
    }

    private int tiling(int n) {
        int[] result = new int[n + 1];
        int[] lastVer = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }

        return result[n];
    }
}
