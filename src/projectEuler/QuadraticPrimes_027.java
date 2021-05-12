package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 09.07.2020.
 */
public class QuadraticPrimes_027 {

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

    static int primeCount(int a, int b) {
    //    System.out.println("a: " + a + " b: " + b);
        int prime_count = 0;
        for (int n = 0; n < Integer.MAX_VALUE; n++) {
            int val = (int) Math.pow(n, 2) + a * n + b;
            if (isPrime(val)) prime_count++;
            else return prime_count;
        }
        return prime_count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int max_prime_count =0;
        int A=0, B =0;
        for(int a=-N; a<=N; a++) {
            for(int b=3; b<=N; b++) {
                if(isPrime(b)) {
                    int prime_count = primeCount(a,b);
                    if( prime_count > max_prime_count) {
                        max_prime_count = prime_count;
                        A=a;
                        B=b;
                    }
                   // System.out.println(prime_count);
                }
            }
        }
      //  System.out.println(max_prime_count);
        System.out.println(A + " " + B);
    }
}
