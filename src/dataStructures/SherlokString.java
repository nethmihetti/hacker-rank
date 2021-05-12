package dataStructures;

import java.io.*;
import java.util.*;
import java.util.Arrays;

/**
 * Created by nethmih on 25.06.2020.
 */
public class SherlokString {
    // Complete the isValid function below.
    static String isValid(String s) {
        int[] stringAry = new int[26];
        char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char ch : s.toCharArray()) {
            for (int i = 0; i < alph.length; i++) {
                if (ch == alph[i]) stringAry[i]++;
            }
        }

        Arrays.sort(stringAry);

        stringAry = Arrays.stream(stringAry).filter(x -> x !=0).toArray();

        for(int a=0; a<stringAry.length; a++) {
            System.out.print(stringAry[a] + ", ");
        }
        System.out.println();

        if(Arrays.stream(stringAry).distinct().count() == 1) return "YES";

        int[] blah = Arrays.copyOfRange(stringAry, 0, stringAry.length-1);
        for(int a=0; a<blah.length; a++) {
            System.out.print(blah[a] + ", ");
        }
        System.out.println();

        if(stringAry.length >= 2) {
            if (stringAry[stringAry.length - 1] - stringAry[stringAry.length - 2] == 1 &&
                    Arrays.stream(Arrays.copyOfRange(stringAry, 0, stringAry.length-1)).distinct().count() == 1) return "YES";
            else if(stringAry[0] == 1 && stringAry[1] != 1 &&
                    Arrays.stream(Arrays.copyOfRange(stringAry, 1, stringAry.length)).distinct().count() == 1) return "YES";
        } else {
            return "YES";
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
