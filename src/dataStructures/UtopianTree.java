package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 22.05.2020.
 */
public class UtopianTree {
    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int i = 1, height = 1;
        while (i <= n) {
            if (i % 2 == 0) {
                height += 1;
            } else {
                height *= 2;
            }
            i++;
        }
        return height;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
