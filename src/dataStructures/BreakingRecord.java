package dataStructures;
import java.io.*;
import java.util.*;
/**
 * Created by nethmih on 19.05.2020.
 */
public class BreakingRecord {
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int max_record = 0;
        int min_record = 0;

        int highest_score = scores[0];
        int lowest_score = scores[0];
        for(int i=1; i<scores.length; i++) {

            if(scores[i] > highest_score) {
                highest_score = scores[i];
                max_record++;
            } else if (scores[i] < lowest_score) {
                lowest_score = scores[i];
                min_record++;
            }
        }
        int[] b = new int [2];
        b[0] = max_record;
        b[1] = min_record;
        return b;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            System.out.println(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
                System.out.println(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
