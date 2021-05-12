package projectEuler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by nethmih on 26.06.2020.
 */
public class FactorialDigitSum_020 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int N = in.nextInt();
           // long fact = 1;
            BigInteger fact1 = BigInteger.ONE;
            for (int i = 1; i <= N; i++) {
                //fact = fact * i;
                fact1 = fact1.multiply(BigInteger.valueOf(i));
            }
           // long sum = 0;
            BigInteger sum1= BigInteger.ZERO;
            while (fact1.compareTo(BigInteger.ZERO) > 0) {
                //sum = sum + fact1 % 10;
                sum1 = fact1.remainder(BigInteger.TEN).add(sum1);
              //  fact = fact / 10;
                fact1 = fact1.divide(BigInteger.TEN);
            }
            System.out.println(sum1);
        }
    }
}
