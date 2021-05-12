package projectEuler;

import java.util.*;

/**
 * Created by nethmih on 28.05.2020.
 */
public class LargestGridProd_011 {

    public static int[][] padArray(int[][] arr, int padWith, int numOfPads) {
        int[][] temp = new int[arr.length + numOfPads*2][arr[0].length + numOfPads*2];
        for (int[] ints : temp) {
            Arrays.fill(ints, padWith);
        }
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, temp[i + numOfPads], numOfPads, arr[i].length);
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        int max_prod=0;
        int[][] padded_grid = padArray(grid, 0, 3);

        for(int grid_i=3; grid_i < padded_grid.length-3; grid_i++){
            for(int grid_j=3; grid_j < padded_grid.length-3; grid_j++){
                int left_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i][(grid_j-1)] * padded_grid[grid_i][(grid_j-2)] * padded_grid[grid_i][(grid_j-3)];
                int right_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i][(grid_j+1)] * padded_grid[grid_i][(grid_j+2)] * padded_grid[grid_i][(grid_j+3)];
                int up_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i-1][grid_j] * padded_grid[grid_i-2][grid_j] * padded_grid[grid_i-3][grid_j];
                int down_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i+1][grid_j] * padded_grid[grid_i+2][grid_j] * padded_grid[grid_i+3][grid_j];

                int right_up_diog_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i-1][grid_j+1] * padded_grid[grid_i-2][grid_j+2] * padded_grid[grid_i-3][grid_j+3];
                int right_down_diog_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i+1][grid_j+1] * padded_grid[grid_i+2][grid_j+2] * padded_grid[grid_i+3][grid_j+3];
                int left_up_diog_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i-1][grid_j-1] * padded_grid[grid_i-2][grid_j-2] * padded_grid[grid_i-3][grid_j-3];
                int left_down_diog_prod = padded_grid[grid_i][grid_j] * padded_grid[grid_i+1][grid_j-1] * padded_grid[grid_i+2][grid_j-2] * padded_grid[grid_i+3][grid_j-3];

                ArrayList<Integer> scoreList = new ArrayList<>();
                scoreList.add(left_prod);
                scoreList.add(right_prod);
                scoreList.add(up_prod);
                scoreList.add(down_prod);
                scoreList.add(right_up_diog_prod);
                scoreList.add(right_down_diog_prod);
                scoreList.add(left_up_diog_prod);
                scoreList.add(left_down_diog_prod);

                int temp_max = Collections.max(scoreList);
                if (temp_max > max_prod) {
                    max_prod = temp_max;
                }
            }
        }

        System.out.println(max_prod);
    }

}
