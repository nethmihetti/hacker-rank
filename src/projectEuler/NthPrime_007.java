package projectEuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nethmih on 17.06.2020.
 */
public class NthPrime_007 {

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
        int t = in.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            if (list.size() >= n) {
                System.out.println(list.get(n - 1));
            } else {
                int start_val = list.get(list.size()-1)+1;

                for(int i= start_val ; i< Integer.MAX_VALUE; i++) {
                    if (list.size() < n && isPrime(i)) list.add(i);

                   /*System.out.println("prime list:");
                    for (Integer integer : list) {
                        System.out.print(integer + " ");
                    }
                    System.out.println();*/
                    //BiiQD54KMnRznJzjzPKJjEeZ


                    if (list.size() == n) {
                        System.out.println(list.get(n - 1));
                        break;
                    }
                }

            }
        }
    }
}
