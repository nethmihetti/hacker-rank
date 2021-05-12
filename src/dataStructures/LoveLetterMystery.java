package dataStructures;

import sun.security.util.ArrayUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by nethmih on 09.09.2020.
 */
public class LoveLetterMystery {


    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        char[] ary = s.toCharArray();

        char[] left_ary = Arrays.copyOfRange(ary, 0,  ary.length/2);

        int right_start = ary.length % 2 == 0 ? ary.length/2 : ary.length/2 +1;
        char[] right_ary = Arrays.copyOfRange(ary, right_start,  ary.length);

        for(int i = 0; i < right_ary.length / 2; i++) {
            char temp = right_ary[i];
            right_ary[i] = right_ary[right_ary.length - i - 1];
            right_ary[right_ary.length - i - 1] = temp;
        }

       /* for(int i=0; i<left_ary.length; i++) {
            System.out.print(left_ary[i]+ ", ");
        }
        System.out.println();

        for(int i=0; i<right_ary.length; i++) {
            System.out.print(right_ary[i]+ ", ");
        }
        System.out.println();*/
        int count =0;
        for(int i=0; i<left_ary.length; i++) {
            int left_index = alph.indexOf(left_ary[i]);
            int right_index = alph.indexOf(right_ary[i]);
            count += Math.abs(right_index-left_index);
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            System.out.println(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
