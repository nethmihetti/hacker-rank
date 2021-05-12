package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 22.05.2020.
 */
public class ChocolateFeast {
    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int total = n / c;
        int int_total = n / c;
        while (int_total > 1) {
            int choc_wrap = int_total / m;
            if (choc_wrap == 0) {
                break;
            }
            int choc_wrap_left = int_total % m;
            total += choc_wrap;
            int_total = choc_wrap + choc_wrap_left;
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
