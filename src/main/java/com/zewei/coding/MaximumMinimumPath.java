package com.zewei.coding;

public class MaximumMinimumPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{8,4,7},{6,5,9}};
        MaximumMinimumPath s = new MaximumMinimumPath();
        System.out.println(s.maximumMinimumPath(matrix));
    }

    private int maximumMinimumPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    row[j] = matrix[i][j];
                } else if (i == n - 1) {
                    row[j] = matrix[i][j + 1];
                } else if (j == m - 1) {
                    row[j] = matrix[i + 1][j];
                } else {
                    row[j] = Math.min(matrix[i][j], Math.max(row[j], row[j + 1]));
                }
            }
        }

        return row[0];
    }
}
