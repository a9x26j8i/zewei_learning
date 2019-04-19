package com.zewei.coding;

import java.util.Arrays;

public class Cubes4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fourCubes()));
    }

    private static int[] fourCubes(){
        int[] result = {-1,-1,-1,-1};
//        int[][] record = new int[15][15];

        for (int a = 0; a <= 15; a++) {
            int a3 = a * a * a;
            for (int b = 15; b >= 0; b--) {
                int b3 = b * b * b;
                int a3b3 = a3 + b3;

                int c = a + 1;
                int d = b - 1;
                while(c < d) {
                    int c3 = c * c * c;
                    int d3 = d * d * d;
                    if (c3 + d3 == a3b3) {
                        result[0] = a;
                        result[1] = b;
                        result[2] = c;
                        result[3] = d;
                        return result;
                    }
                    else if (c3 + d3 > a3b3) {
                        d--;
                    } else {
                        c++;
                    }
                }
            }
        }

        return result;
    }
}
