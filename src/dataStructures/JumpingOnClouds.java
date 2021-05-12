package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 19.02.2021.
 */
public class JumpingOnClouds {

    private static int getJumpingCloudIndex(int i, int k, int n) {
        return (i + k) % n;
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int size = c.length;
        int i =0;
        while (i < size) {
            int jumpIdx = getJumpingCloudIndex(i, k, size);
           // System.out.println("jumpIdx: " + jumpIdx);
            if (c[jumpIdx] == 1) energy = energy - 3;
            else if (c[jumpIdx] == 0) energy = energy - 1;

            if (jumpIdx == 0) break;
            i = jumpIdx;
         //   System.out.println("energy: " + energy);
        }
        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
