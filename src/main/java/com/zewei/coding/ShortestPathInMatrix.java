package com.zewei.coding;

import java.util.LinkedList;
import java.util.Queue;
//dfs
public class ShortestPathInMatrix {
    public static int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 9, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};

        ShortestPathInMatrix s = new ShortestPathInMatrix();
        System.out.println(s.shortestPathMatrix(matrix));
    }

    //dfs
    private int shortestPathMatrix (int[][] matrix){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        rows.add(0);
        cols.add(0);

        int depth = 0;
        while(!rows.isEmpty()) {
            final int size = rows.size();
            for (int i = 0; i < size; i++) {
                int row = rows.remove();
                int col = cols.remove();
                //stop case
                if (matrix[row][col] == 9) {
                    return depth;
                }
                //bfs children
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (isValid(newRow, newCol, matrix, visited)) {
                        visited[newRow][newCol] = true;
                        rows.add(newRow);
                        cols.add(newCol);
                    }
                }
            }
            depth++;
        }

        return depth + 1;
    }

    private boolean isValid(int row, int col, int[][] matrix, boolean[][] visited) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (row >= 0 && row < n && col < m && col >= 0
                && (matrix[row][col] == 1 || matrix[row][col] == 9)
                && !visited[row][col]) {
            return true;
        } else {
            return false;
        }
    }
}
