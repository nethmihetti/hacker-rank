package projectEuler;

import java.util.Scanner;

/**
 * Created by nethmih on 16.07.2020.
 */
public class CodedTriangle_042 {
    static int isTriangleNumber(long t) {
        double plusN = ((-1) + Math.sqrt(8*t+1))/2;
        //System.out.println("plusN: " + plusN);
        if(plusN == (int) plusN) return (int) plusN;
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            long t = in.nextLong();
            System.out.println(isTriangleNumber(t));
        }
    }
}
