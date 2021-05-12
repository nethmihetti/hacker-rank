package dataStructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by nethmih on 15.09.2020.
 */
public class LisasWorkbook {
    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int page=1;
        int count =0;
        int specialCount =0;
        for(int i=0; i<n; i++) {
            for(int j=1; j<=arr[i]; j++) {

                count++;

                System.out.println("j: " + j + " page: " + page);
                if(j == page) specialCount++;

                if(count == k || j == arr[i]) {
                    page++;
                    count=0;
                }
            }
        }


        return specialCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
