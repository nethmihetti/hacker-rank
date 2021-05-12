package projectEuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nethmih on 03.07.2020.
 */
public class TruncatablePrimes_037 {

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

    static boolean isLRPrimeTruncate(int n) {
        System.out.println("n: " + n);
        String number = Integer.toString(n);
        boolean isPrimeTruncate = false;
        for (int i = 1; i < number.length()+1; i++) {
            int b = Integer.parseInt(number.substring(0, i));
            System.out.println(b);
            isPrimeTruncate = isPrime(b);
            if (!isPrimeTruncate) return false;
        }
        System.out.println("//////////////");
        return isPrimeTruncate;
    }

    static boolean isRLPrimeTruncate(int n) {
        System.out.println("n: " + n);
        String number = Integer.toString(n);
        boolean isPrimeTruncate = false;
        for (int i = number.length(); i >= 1; i--) {
            int b = Integer.parseInt(number.substring(0, i));
            System.out.println(b);
            isPrimeTruncate = isPrime(b);
            if (!isPrimeTruncate) return false;
        }
        System.out.println("//////////////");
        return isPrimeTruncate;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       /* System.out.println(isLRPrimeTruncate(35));
        System.out.println(isRLPrimeTruncate(35));*/
        int N = in.nextInt();
        List<Integer> primeAry = new ArrayList<>();
        int[] truncPrimes = new int[] {23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397};
        int tot=0;
        for (int i = 0; i < truncPrimes.length; i++) {
            //if (isPrimeTruncate(i) && isPrimeTruncate(Integer.parseInt(new StringBuilder(Integer.toString(i)).reverse().toString()))) primeAry.add(i);
            if(truncPrimes[i]<N) tot+=truncPrimes[i];
        }

      /*  for(int j=0; j< primeAry.size(); j++){
            System.out.print(primeAry.get(j) + ", ");
        }*/
      System.out.println(tot);
    }
}
