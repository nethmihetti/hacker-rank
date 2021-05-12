package dataStructures;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by nethmih on 25.06.2020.
 */
public class SpecialString {
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        char[] charArray = s.toCharArray();
        // System.out.println(isSpecialString(charArray));

        long count =0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char[] blah = Arrays.copyOfRange(charArray, i, j + 1);

                if(isSpecialString(blah)) {
                    count++;

                    for (int r = 0; r < blah.length; r++) {
                        System.out.print(blah[r] + ", ");
                    }
                    System.out.println();
                }
            }
        }

        return count;
    }

    public static long substrCount1(int length, String s) {
        long counter = 0;
        for (int i = 0; i < length; i++) {
            // if the current symbol is in the middle of palindrome, e.g. aba
            int offset = 1;
            while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1)
                    && s.charAt(i + offset) == s.charAt(i - 1)) {
                counter++;
                offset++;
            }
            // if this is repeatable characters aa
            int repeats = 0;
            while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                repeats++;
                i++;
            }
            counter += repeats * (repeats + 1) / 2;
        }
        return counter + length;
    }

    static boolean isSpecialString(char[] subAry) {
        Stream<Character> cStream = IntStream.range(0, subAry.length).mapToObj(i -> subAry[i]);
        if (cStream.distinct().count() == 1) return true;
        if(subAry.length % 2 == 0) return false;

        char b = subAry[0];
        int len = subAry.length;
        for (int i = 0; i < len / 2; i++) {
            if (subAry[i] != subAry[len - 1 - i]) return false;
            if(subAry[i] != b) return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
