package projectEuler;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 09.02.2021.
 */
public class PathSum_081 {

    private static long calculateLowestPathSum(long[][] grid, int N) {
        long[][] newGrid = new long[N][N];
        newGrid[0][0] = grid[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j>=1) {
                    newGrid[i][j] = grid[i][j] + newGrid[i][j-1];
                }
                if (j == 0 && i>=1) {
                    newGrid[i][j] = grid[i][j] + newGrid[i-1][j];
                }
                if ((i - 1) >= 0 && (j - 1) >= 0) {
                    newGrid[i][j] = grid[i][j] + Math.min(newGrid[i - 1][j], newGrid[i][j - 1]);
                }
            }
        }

        return newGrid[N-1][N-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[][] grid = new long[N][N];
        for (int grid_i = 0; grid_i < N; grid_i++) {
            for (int grid_j = 0; grid_j < N; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        System.out.println(calculateLowestPathSum(grid, N));
    }
}
