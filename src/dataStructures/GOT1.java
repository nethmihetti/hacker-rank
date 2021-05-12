package dataStructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nethmih on 10.09.2020.
 */
public class GOT1 {
    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int[] count = new int[26];
        String alph = "abcdefghijklmnopqrstuvwxyz";
        char[] ary = s.toCharArray();
        for(int i=0; i<ary.length; i++) {
            int index = alph.indexOf(ary[i]);
            System.out.println(index);
            count[index]++;
        }
        Arrays.sort(count);

        /*for(int i=count.length-1; i>=0; i--) {
            System.out.print(count[i] + ", ");
        }
        System.out.println();*/

        boolean isOneOdd = isOneOddOccurrences(count);
        for(int i=count.length-1; i>=0; i--) {
            if(count[i] % 2 != 0 && count[i] != 0 && !isOneOdd ) return "NO";
        }



        return "YES";
    }

    static boolean isOneOddOccurrences(int[] ary) {
        int count =0;
        for (int value : ary) {
            if (value % 2 != 0) count++;
        }
        return count == 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
