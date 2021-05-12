package projectEuler;

import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nethmih on 08.06.2020.
 */
public class CircularPrime_035 {

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


    static ArrayList<Integer> cyclic(int N) {
        int num = N;
        int n = Integer.toString(N).length();

        ArrayList<Integer> circularAry = new ArrayList<>();
        while (true) {
            if(num != 0) circularAry.add(num);

            int rem = num % 10;
            int dev = num / 10;
            num = (int)((Math.pow(10, n - 1)) * rem + dev);

            if (num == N)
                break;
        }
        return circularAry;
    }

    static boolean isCircularPrime(int n) {
        ArrayList<Integer> circularPurm = cyclic(n);

        for (Integer integer : circularPurm) {
            if (!isPrime(integer)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Instant start = Instant.now();
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            boolean isDivisible = false;
            if(i != 2 && Integer.toString(i).matches(".*[024685].*")) isDivisible = true;
            if (!isDivisible && isCircularPrime(i)) sum += i;
        }

        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

        in.close();
    }
}
