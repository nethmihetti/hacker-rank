package projectEuler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by nethmih on 28.05.2020.
 */
public class LargeSum_013 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        BigInteger sum = BigInteger.ZERO;
      //  sum.multiply();

        for (int a0 = 0; a0 < N; a0++) {
            sum = sum.add(in.nextBigInteger());
        }
        System.out.println(sum.toString().substring(0, 10));
    }
}
