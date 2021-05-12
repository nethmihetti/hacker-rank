package projectEuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nethmih on 06.08.2020.
 */
public class PrimeSummation_010 {
    private static List<Integer> primes = new ArrayList<>();

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

    static int getPrimeSum(int n) {
        int sum = 0;
        int start_index = Math.max(primes.size() - 1, 0);
        int start_val = 2;
        if (start_index != 0) start_val = primes.get(start_index);
        for (int i = start_val+1; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        for (Integer prime : primes) {
            System.out.print(prime + ", ");
        }
        System.out.println();

        for (Integer prime : primes) {
            if (prime > n) break;
            else sum = sum + prime;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        primes.add(2);
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(getPrimeSum(n));
        }
    }
}
