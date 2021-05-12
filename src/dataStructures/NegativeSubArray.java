package dataStructures;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nethmih on 23.06.2020.
 */
public class NegativeSubArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }

        int totNegative = 0;
        for (int j = 0; j < array.length; j++) {
            for (int k = j + 1; k <= array.length; k++) {
                int[] sub_ary = Arrays.copyOfRange(array, j, k);

              /*  for (int q = 0; q < sub_ary.length; q++) {
                    System.out.print(sub_ary[q] + ", ");
                }
                System.out.println();*/

                int sum = Arrays.stream(sub_ary).sum();
                if (sum < 0) totNegative++;
            }
        }

        System.out.println(totNegative);

        scan.close();
    }
}
