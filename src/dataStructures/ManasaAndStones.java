package dataStructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by nethmih on 14.09.2020.
 */
public class ManasaAndStones {

    // Convert the number to Lth
// base and print the sequence
    private static int convert_To_Len_th_base(int n, int[] arr, int len, int L) {
        // Sequence is of length L
        int[] sub_arr = new int[L];
        for (int i = 0; i < L; i++) {
            // Print the ith element
            // of sequence
            if(i==0) sub_arr[i] = arr[n % len];
            else sub_arr[i] = sub_arr[i-1] + arr[n % len];
            n /= len;
        }

        return sub_arr[sub_arr.length-1];
    }

    // Print all the permuataions
    private static List<Integer> print(int[] arr, int len, int L) {
        // There can be (len)^l
        // permutations
        System.out.println("Array Size: " + (int)Math.pow(len, L));
      //  int [] arr2 = new int[(int)Math.pow(len, L)];
        List<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < (int)Math.pow(len, L); i++) {
            // Convert i to len th base
            arr2.add(convert_To_Len_th_base(i, arr, len, L));
        }
       // Arrays.sort(arr2);
        return  arr2;
    }

    // Complete the stones function below.
    static List<Integer> stones(int n, int a, int b) {
        int[] arr = {a, b};
        List<Integer> res = print(arr, 2, n-1);

        // removing the duplicates
        int end = res.size();
        Set<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < end; i++){
            set.add(res.get(i));
        }

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            List<Integer> result = stones(n, a, b);

            for(int i=0; i<result.size(); i++) {
                System.out.print(result.get(i) + ", ");
            }
            System.out.println();

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

