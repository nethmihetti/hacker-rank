package projectEuler;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by nethmih on 07.08.2020.
 */
public class PrimeSummation_077 {
    private static HashMap<Integer, Integer> primes_hash = new HashMap<Integer, Integer>();
    //private static List<Integer> primes = new ArrayList<>();


    static int count(Integer[] S, int m, int n ) {

        if (n == 0) return 1;
        if (n < 0) return 0;
        if (m <=0 && n >= 1) return 0;

        return count(S, m - 1, n ) + count(S, m, n-S[m-1] );
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int latest_prime = 2;


        Integer[] spam = new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
        List<Integer> primes = Arrays.asList(spam);

        for (int i = 2; i <= 1000; i++) {
            if (primes.contains(i)) {
                primes_hash.put(i, i);
                latest_prime = i;
            } else {
                primes_hash.put(i, latest_prime);
            }
        }
        System.out.println(primes);
        System.out.println(primes_hash);
        for (int a0 = 0; a0 < t; a0++) {
            int num = in.nextInt();

            int closest_prime = primes_hash.get(num);
            int index = primes.indexOf(num);

            System.out.println("index1: " + index);
            System.out.println("closest_prime: " + closest_prime);

            if (index == -1) {
                index = primes.indexOf(closest_prime);
            }


            System.out.println(index);

           // int[] subAry = primes.subList(0, index).toArray(new int[primes.subList(0, index).size()]);
            Integer[] blah = primes.subList(0, index+1).toArray(new Integer[0]);

          //  Object[] blah1 = primes.values().toArray();

          //  Set<Object> set = new HashSet<Object>(Arrays.asList(blah1));
            //(0, index+1).toArray(new Integer[0]);

        /*    for(int i=0; i<blah.length; i++) {
                System.out.print(blah[i] + ", ");
            }
            System.out.println("////");*/
        //    Integer[] subAry = (Integer[]) Arrays.copyOfRange(set.toArray(), 0, index + 1);

            System.out.println(count(blah, blah.length, num));
        }
    }
}
