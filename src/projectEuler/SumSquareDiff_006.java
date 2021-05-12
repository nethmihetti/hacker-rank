package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 24.05.2020.
 */
public class SumSquareDiff_006 {

    private static long getSumSquareDif(long n) {
        long sum = (n * (n+1))/2;
        long squareSum = (n*(n+1)*(2*n+1))/6;
        return (long) Math.abs((squareSum - Math.pow(sum,2)));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            long result = getSumSquareDif(n);
            System.out.println(result);
        }
    }
}
