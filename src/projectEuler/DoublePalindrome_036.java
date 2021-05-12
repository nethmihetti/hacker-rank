package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 08.06.2020.
 */
public class DoublePalindrome_036 {

    private static boolean isPalindrome(String word) {
        String reverse = new StringBuilder(word).reverse().toString();
        return word.equals(reverse);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            String baseConverted = Integer.toString(Integer.parseInt(Integer.toString(i), 10), K);
            if (isPalindrome(Integer.toString(i)) && isPalindrome(baseConverted)) sum += i;

        }

        System.out.println(sum);
        in.close();
    }
}
