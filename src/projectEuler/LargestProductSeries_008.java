package projectEuler;

import java.util.*;

/**
 * Created by nethmih on 28.05.2020.
 */
public class LargestProductSeries_008 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();

            int max = 0;
            for(int i=0; i< n -k; i++) {
                String tempStr = num.substring(i, i+k);
                char[] tempStrAry = tempStr.toCharArray();
                int tempMax = 1;
                for (char c : tempStrAry) {
                    tempMax = tempMax * Character.getNumericValue(c);
                }

                if (tempMax> max) {
                    max = tempMax;
                }

            }
            System.out.println(max);
        }
    }
}
