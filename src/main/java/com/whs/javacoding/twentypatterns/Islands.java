package com.whs.javacoding.twentypatterns;

public class Islands {
    private static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static int countIslands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        for (int[] dir : directions) {
            dfs(grid, x + dir[0], y + dir[1]);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        System.out.println(countIslands(grid)); // Output: 3
    }
}