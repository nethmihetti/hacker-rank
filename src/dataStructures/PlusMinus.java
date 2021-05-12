package dataStructures;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by nethmih on 21.05.2020.
 */
public class PlusMinus {
    static void plusMinus(int[] arr) {
        int plus_count = 0, negative_count = 0, zero_count = 0;
        for (int value : arr) {
            if (value > 0) {
                plus_count++;
            } else if (value < 0) {
                negative_count++;
            } else {
                zero_count++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println(df.format( (double)plus_count / arr.length));
        System.out.println(df.format( (double)negative_count / arr.length));
        System.out.println(df.format( (double)zero_count / arr.length));

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
