package projectEuler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nethmih on 17.06.2020.
 */
public class GoldBachConjecture_046 {

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


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int tot=0;
            for (int j = 1; j <= N; j++) {
                double b = 2 * Math.pow(j, 2);
                double remainder = N - b;
                if (remainder > 1 && isPrime((int) remainder)) {
                  //  System.out.println("remainder: " + remainder + " 2nd prime: " + j);
                    tot++;
                }
            }

            System.out.println(tot);
        }
    }
}
