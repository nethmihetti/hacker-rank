package projectEuler;

import java.util.*;

/**
 * Created by nethmih on 28.05.2020.
 */
public class SmallestMultiply_005 {

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

    static List<Integer> getPrimesBelowN(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) list.add(i);
        }

        return list;
    }

    static int getMaxPowInt(int prime, int num) {
        for (int i = 1; i < num; i++) {
            double pow = Math.pow(prime, i);
            if (pow > num) return i - 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            List<Integer> primeList = getPrimesBelowN(n);
            int num=1;
            for (Integer integer : primeList) {
                num *= Math.pow(integer, getMaxPowInt(integer, n));
            }
            System.out.println(num);
        }
    }
}
