package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 19.06.2020.
 */
public class LargestPalindromeProd_004 {

    static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int largest = 1;
            for(int i=999; i>=100; i--) {
                for(int j=999; j>=100; j--) {
                    int prod = i*j;
                    if(prod<n && prod > largest  && isPalindrome(Integer.toString(prod))) {
                        largest = prod;
                        //System.out.println(prod);
                        //break;
                    }
                }
            }
           // System.out.println("largest");
            System.out.println(largest);
        }
    }
}
