package dataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by nethmih on 05.03.2021.
 */
public class SherlokAndBeast {
    static private int getModOfFive(int n) {
        return n % 5;
    }
    static private int getModOfThree(int n) {
        return n % 3;
    }
    static private int getCountOfFiveDivide(int n) {
        return n / 5;
    }
    static private int getCountOfThreeDivide(int n) {
        return n / 3;
    }

    static private void printResult(int fiveCount, int threeCount) {

        /*String s = "5".repeat(Math.max(0, fiveCount)) +
                "3".repeat(Math.max(0, threeCount));*/


        StringBuilder s = new StringBuilder();
        for(int i=0; i<fiveCount; i++) {
            s.append("5");
        }
        for(int i=0; i<threeCount; i++) {
            s.append("3");
        }
        System.out.println(s);
    }

    // Complete the decentNumber function below.
    static private void decentNumber(int n) {
       /* int fiveCount = getCountOfFiveDivide(n); // 99/5=19
        int fiveMod = getModOfThree(n); // 1
        if (fiveMod == 0) {
            printResult(n, 0);
            return;
        }
        if (getModOfThree(fiveMod) == 0) {
            printResult(fiveCount * 5, 3 * getCountOfThreeDivide(fiveMod));
            return;
        }
        for (int i = (fiveCount - 1); i >= 1; i--) {
            int b = getModOfThree(n - i * 5);
            if (b == 0) {
                printResult(i * 5, 3 * getCountOfThreeDivide(getCountOfThreeDivide(n - i * 5)));
                return;
            }
        }
        System.out.println("-1");*/

        int y = n;
        int z = y;
        while (z % 3 != 0) {
            z -= 5;
        }
        if (z < 0) {
            System.out.println("-1");
        } else {
           // System.out.println(z * '5' + (y - z) * '3');
            printResult(z, (y-z));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
