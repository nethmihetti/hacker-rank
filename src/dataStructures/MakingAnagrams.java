package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 25.06.2020.
 */
public class MakingAnagrams {
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int count =0;
        int[] stringA = new int[26];
        int[] stringB = new int[26];
        char[] alph = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char ch : a.toCharArray()) {
            for (int i = 0; i < alph.length; i++) {
                if (ch == alph[i]) stringA[i]++;
            }
        }

        for (char ch : b.toCharArray()) {
            for (int i = 0; i < alph.length; i++) {
                if (ch == alph[i]) stringB[i]++;
            }
        }

        for(int j=0; j<26; j++) {
            int abs = Math.abs(stringA[j] - stringB[j]);
            if(abs > 0 ) count+= abs;
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
