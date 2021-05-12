package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 26.06.2020.
 */
public class PythagoreanTriplet_009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int N = in.nextInt();
            long maxProd = 1;
            for (int a = 1; a < N / 2; a++) {
                double doubleB = (Math.pow(N, 2) - 2 * N * a) / (2 * (N - a));
                int b = (int) doubleB;
                System.out.println("a: " + a);
                System.out.println("doubleB: " + doubleB + " b:" + b);
                double doubleC = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                int c = (int) doubleC;
                System.out.println("doubleC: " + doubleC + " c:" + c);
                System.out.println();
                if (doubleB == b && doubleC == c && a < b && b < c && ((a + b + c) == N) && (a * b * c) > maxProd)
                    maxProd = a * b * c;

            }
            if (maxProd != 1) System.out.println(maxProd);
            else System.out.println("-1");
        }
    }
}
