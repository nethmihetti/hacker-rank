package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 24.05.2020.
 */
public class EvenFibonacci_002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a = 0; a < t; a++) {
            long n = in.nextLong();
            long f1 = 0;
            long f2 = 1;
            long sum = 0;
            while(f1 + f2 < n) {
                if((f1 + f2) % 2 == 0) sum += f1 + f2;
                long temp = f2;
                f2 = f1 + f2;
                f1 = temp;
            }
            System.out.println(sum);
        }
    }
}
