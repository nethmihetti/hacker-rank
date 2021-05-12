package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 24.05.2020.
 */
public class LargestPrimeFactor_003 {

    static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            for (long i = n; i >= 1; i--) {
                if (isPrime(i) && (n % i == 0)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
