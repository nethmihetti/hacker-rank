package projectEuler;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by nethmih on 29.05.2020.
 */
public class MaxPathSum_018 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int rows = in.nextInt();
            int[][] tri = new int[rows][rows];
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < rows; k++) {
                    tri[j][k] = in.nextInt();
                    if (j == k) {
                        break;
                    }

                }
            }

            for(int i1=0; i1< tri.length; i1++) {
                for(int j1=0; j1< tri.length; j1++) {
                    System.out.print(tri[i1][j1] + " ");
                }
                System.out.println();
            }

            int max_sum = tri[0][0];
            int index = 0;
/*            for (int j = 0; j < rows - 1; j++) {
                for (int k = 0; k < rows - 1; k++) {
                    if(j==k) break;
                    int cand1 = tri[j + 1][k];
                    int cand2 = tri[j + 1][k + 1];
                    System.out.println("cand1: " + cand1 + " cand2: " + cand2 + " index: " + index);
                    if (cand1 > cand2) {
                        System.out.println("max_sum: " + max_sum + " + " + cand2);
                        max_sum += cand1;
                        System.out.println("i chose cand1 " + cand1);
                    } else {
                        //  System.out.println("max_sum: " + max_sum +" + " + cand1 );
                        // System.out.println("i chose cand2 " + cand2);

                        max_sum += cand2;
                        index++;
                        //index =k;
                    }
                }
            }*/


            for (int i2 = tri.length - 2; i2 >= 0; i2--) {
                for (int j2 = 0; j2 < tri[i2].length; j2++) {
                    if (i2==j2) break;
                    System.out.println("i2: " + i2 + " j2: " + j2);
                     System.out.println("tri[i2 + 1][j2] " + tri[i2 + 1][j2] + " tri[i2 + 1][j2 + 1] " + tri[i2 + 1][j2 + 1] );
                    tri[i2][j2] += Math.max(tri[i2 + 1][j2], tri[i2 + 1][j2 + 1]);
                }
            }
            System.out.println(Integer.toString(tri[0][0]));

            //System.out.println(max_sum);
        }
    }
}
