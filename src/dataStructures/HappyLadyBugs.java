package dataStructures;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by nethmih on 17.09.2020.
 */
public class HappyLadyBugs {
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        char[] ary = b.toCharArray();
        int[] countAry = new int[26];
        int _count = 0;

        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < ary.length; i++) {
          //  System.out.print(alph.indexOf(ary[i]));
            if (ary[i] == '_') _count++;
            else countAry[alph.indexOf(ary[i])]++;
        }

        /*for(int i=0;i<countAry.length; i++){
            System.out.print(countAry[i] + ", ");
        }
        System.out.println();*/

        System.out.println(isHappyAry(ary));
        if (isHappyAry(ary) && _count == 0) return "YES";
        if (_count >= 1) {
            boolean contains = IntStream.of(countAry).anyMatch(x -> x == 1);
            if (!contains) return "YES";
            return "NO";
        }

        return "NO";


    }

    private static boolean isHappyAry(char[] ary) {
        if(ary.length ==1) return false;
        if(ary.length >2 && ary[ary.length-1] != ary[ary.length-2] ) return false;
        for (int i = 0; i < ary.length - 1; i++) {
            if (i == 0 && ary[i] != ary[i + 1]) {
                return false;
            } else if (ary[i] != ary[i + 1] && ary[i] != ary[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            System.out.println(result);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
