package projectEuler;

import java.util.*;

/**
 * Created by nethmih on 09.07.2020.
 */
public class PanDigitProduct_032 {
    private static boolean isPanDigital(int multiplicand, int multiplier, int N) {
        String pan = "";
        for (int i = 1; i <= N; i++) {
            pan = pan.concat(Integer.toString(i));
        }

        int product = multiplicand * multiplier;
        String b = Integer.toString(multiplicand).concat(Integer.toString(multiplier)).concat(Integer.toString(product));

        if(b.length() != pan.length()) return false;

        char[] stringAry = b.toCharArray();

        Arrays.sort(stringAry);
        String blah = "";

        for (char c : stringAry) {
            // System.out.print(stringAry[j] + ", ");
            blah = blah.concat(Character.toString(c));
        }
       // System.out.println(blah);

        return blah.equals(pan);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long endVal = (long)Math.pow(10, N)-1;
        int end = (int)Math.sqrt(endVal);
        List<Integer> sumList = new ArrayList<>();
        for (int i = 1; i < end; i++) {
            for (int j = 1; j < end; j++) {
                int product = i * j;
                int iLength = Integer.toString(i).length();
                int jLength = Integer.toString(j).length();
                int productLength = Integer.toString(product).length();
                if (iLength + jLength + productLength == N) {
                    if (isPanDigital(i, j, N)) {
                       // System.out.println("i: " + i + " j:" + j);
                        int prod = i * j;
                        sumList.add(prod);
                    }
                } else if (iLength + jLength + productLength > N) break;
            }
        }
        Set<Integer> mySet = new HashSet<>(sumList);
        System.out.println(mySet.stream().mapToInt(Integer::intValue).sum());
    }
}
