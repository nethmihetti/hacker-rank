package projectEuler;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nethmih on 03.06.2020.
 */
public class NonAbundantSums_023 {
    private static boolean isAbundantNum(int num) {
        ArrayList<Integer> factors = new ArrayList<Integer>();

        // Skip two if the number is odd
        int incrementer = num % 2 == 0 ? 1 : 2;
        for (int i = 1; i <= Math.sqrt(num); i += incrementer) {
            // If there is no remainder, then the number is a factor.
            if (num % i == 0) {
                factors.add(i);
                // Skip duplicates
                if (i != num / i) {
                    factors.add(num / i);
                }
            }
        }

        int sum = factors.stream().mapToInt(i -> i).filter(i -> i != num).sum();
        return sum > num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i1 = 0; i1 < T; i1++) {
            int N = in.nextInt();
            boolean found = false;
            for (int i = 1; i <= N; i++) {
                int num2 = N - i;
                if (isAbundantNum(i) && isAbundantNum(num2)) {
                    found = true;
                    break;
                }
            }
            if (found) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}
