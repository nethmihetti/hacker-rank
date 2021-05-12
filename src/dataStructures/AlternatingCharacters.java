package dataStructures;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by nethmih on 23.05.2020.
 */
public class AlternatingCharacters {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char[] stringAry = s.toCharArray();
        int del_count = 0;
        for (int i = 0; i < stringAry.length - 1; i++) {
            if (stringAry[i] == stringAry[i + 1]) {
                del_count++;
            }
        }
        return del_count;
    }

    // Complete the findDigits function below.
    static int findDigits(int n) {
        char[] numberAry = Integer.toString(n).toCharArray();
        int count = 0;
        for (char c : numberAry) {
            if (Character.getNumericValue(c) != 0 && (n % Character.getNumericValue(c) == 0)) {
                count++;
            }
        }
        return count;
    }

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"};
        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m > 0 && m <= 30) {
            if (m == 15) {
                return "quarter past " + numbers[h];
            } else if (m == 30) {
                return "half past " + numbers[h];
            } else if (m == 1) {
                return numbers[m] + " minute past " + numbers[h];
            } else {
                return numbers[m] + " minutes past " + numbers[h];
            }
        } else {
            if (m == 45) {
                return "quarter to " + numbers[h + 1];
            } else {
                return numbers[(60 - m)] + " minutes to " + numbers[h + 1];
            }

        }

    }

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.trim();
        double sqrt = Math.sqrt(s.length());
        int rows = (int) Math.floor(sqrt);
        int columns = (int) Math.ceil(sqrt);
        char[] stringAry = s.toCharArray();
        System.out.println(rows);
        System.out.println(columns);

        if (rows * columns < s.length()) {
            boolean cond = true;
            while (cond) {
                if (rows < columns) {
                    rows++;
                } else {
                    columns++;
                }
                if (rows * columns >= s.length()) {
                    cond = false;
                }
            }

        }

        if (rows * columns >= s.length()) {
            char[][] matrix = new char[rows][columns];
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (count < s.length()) {
                        matrix[i][j] = stringAry[count];
                        count++;
                    } else {
                        matrix[i][j] = '0';
                    }
                }
            }


            StringBuilder b = new StringBuilder();
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    if(matrix[j][i] != '0') {
                        b.append(matrix[j][i]);
                    }
                }
                b.append(" ");
            }
            return b.toString();
        }
        return "";
    }

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        Arrays.sort(arr);
        int count =0;
        for (int triplet1 : arr) {
            int triplet2 = triplet1 + d;
            int triplet3 = triplet2 + d;

            if (Arrays.stream(arr).anyMatch(x -> x == triplet2) && Arrays.stream(arr).anyMatch(x -> x == triplet3)) {
                count++;
            }
        }
        return count;
    }

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int int_likes = (int) Math.floor((double) 5 / 2);
        int tot = int_likes;
        for (int i = 1; i < n; i++) {

            int shares = int_likes * 3;
            int_likes = (int) Math.floor((double) shares / 2);
            tot += int_likes;
        }
        return tot;
    }

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int a = i; a <= j; a++) {
            int revInt = Integer.parseInt(new StringBuilder(Integer.toString(a)).reverse().toString());
            int dif = Math.abs(a - revInt);
            if (dif % k == 0) count++;
        }

        return count;
    }

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger prod = BigInteger.ONE;
        for(int i=1; i<=n; i++) {
            prod = prod.multiply(BigInteger.valueOf(i));
        }
        System.out.println(prod);
    }

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int min_dis = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    int dist = j - i;
                    if (dist < min_dis) min_dis = dist;
                }
            }
        }
        if (min_dis == Integer.MAX_VALUE) return -1;
        return min_dis;
    }

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        int count = 0;
        if (s - p > 0) {
            count++;
            s = s - p;
            p = p - d;
        } else {
            return count;
        }
        while (s >= 0) {
            if ((s - p - d) >= 0 && p >= m) {
                count++;
                s = s - p;
                p = p - d;
                System.out.println("first Variant: s=" + s + " count:"+ count);
            } else if (p < m && (s-m) >= 0) {
                count++;
                s = s - m;
                System.out.println("second Variant: s=" + s + " count: " +count);
            } else {
                System.out.println("WTF s= " + s + " (p-d) = " + (p - d) + " count:" + count);
                break;
            }
        }
        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));


        /*int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();

            int result = findDigits(n);
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }*/

/*        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();*/

       /* String s = scanner.nextLine();

        String result = encryption(s);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();*/

/*        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/
/*
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/

/*        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.print(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/
/*
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();*/


    /*    int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/


        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);
        System.out.println(answer);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
