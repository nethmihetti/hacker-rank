package dataStructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by nethmih on 25.09.2020.
 */
public class CavityMap {
    // Complete the cavityMap function below.
    static String[][] cavityMap(String[][] grid) {
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid.length - 1; j++) {

                int top = Integer.parseInt(grid[i - 1][j]);
                int bottom = Integer.parseInt(grid[i + 1][j]);
                int left = Integer.parseInt(grid[i][j - 1]);
                int right = Integer.parseInt(grid[i][j + 1]);
                int curr = Integer.parseInt(grid[i][j]);

                System.out.print(top + " , " + bottom + " , " + left + " , " + right );
                if(curr > top && curr > bottom && curr > left && curr > right) grid[i][j] = "X";
            }
        }

        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[][] grid = new String[n][n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            String[] ary = gridItem.split("");
            System.arraycopy(ary, 0, grid[i], 0, n);

        }

        String[][] result = cavityMap(grid);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               System.out.print(result[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int top = Integer.parseInt(grid[i - 1][j]);
                int bottom = Integer.parseInt(grid[i + 1][j]);
                int left = Integer.parseInt(grid[i][j - 1]);
                int right = Integer.parseInt(grid[i][j + 1]);
                int curr = Integer.parseInt(grid[i][j]);
                bufferedWriter.write(result[i][j]);

                if (i != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
