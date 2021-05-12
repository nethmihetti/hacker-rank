package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 08.06.2020.
 */
public class BiggerIsGreater {
    // Complete the biggerIsGreater function below.
    static int getScore(String w) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] wordAry = w.toCharArray();
        int score = 0;
        for (int i=0; i< wordAry.length; i++) {
            int alph_index = alphabet.indexOf(wordAry[i]);
            score += ((alph_index + 1) * (i+1));
        }
        return score;
    }

     static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    static String biggerIsGreater(String w) {
        /*int int_Score = getScore(w);
        char[] wordAry = w.toCharArray();
        for (int i = wordAry.length - 1; i >= 0; i--) {

        }*/
        permutation("", w);

        return "";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
