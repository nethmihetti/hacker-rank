package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 21.05.2020.
 */
public class FraudNotification {

    private static double getMedian(int[] ary) {
        Arrays.sort(ary);
        double median;
        int totalElements = ary.length;
        if (totalElements % 2 == 0) {
            int sumOfMiddleElements = ary[totalElements / 2] + ary[totalElements / 2 - 1];
            median = ((double) sumOfMiddleElements) / 2;
        } else {
            median = (double) ary[ary.length / 2];
        }
        return median;
    }

    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        for (int i = 0; i < expenditure.length; i++) {
            if (i >= d) {
                int[] newArray = Arrays.copyOfRange(expenditure, (i - d), i);
                double median = getMedian(newArray);
                if(median*2 <= expenditure[i]) {
                    count++;
                }
            }

        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
