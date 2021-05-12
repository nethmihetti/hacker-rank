package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 17.06.2020.
 */
public class DigitFactorials_034 {

    private static long getFactorial(int num) {
        if (num == 0) return 1;
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long totSum = 0;
        for (int j = 10; j <= N; j++) {
            char[] numToCharAry = Integer.toString(j).toCharArray();
            long sum = 0;
            for (char c : numToCharAry) {
                sum += getFactorial(Integer.parseInt(String.valueOf(c)));
            }
            if (sum % j == 0) {
               // System.out.println("found: " + j);
                totSum += j;
            }

        }
        System.out.println(totSum);
    }
}
