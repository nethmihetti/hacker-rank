package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 22.05.2020.
 */
public class PDFViewer {
    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int length = word.length();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] wordAry = word.toCharArray();
        int max_index = 0;
        for (char c : wordAry) {
            int alph_index = alphabet.indexOf(c);
            if (h[alph_index] > max_index) {
                max_index = h[alph_index];
            }
        }
        return max_index * length;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
