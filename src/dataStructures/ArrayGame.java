package dataStructures;

import java.util.*;

/**
 * Created by nethmih on 23.06.2020.
 */
public class ArrayGame {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        /*for (int i = 0; i < game.length - 1; i++) {
            if (game[i + 1] == 0) continue;
            if (i + leap < game.length && game[i + 1] == 1 && game[i + leap] == 0) continue;
            if (i + leap < game.length && game[i + 1] == 1 && game[i + leap] == 1) return false;
        }
        return true;*/


  /*      if (i < 0 || arr[i] == 1) return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);*/
  return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
