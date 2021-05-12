package dataStructures;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by nethmih on 21.05.2020.
 */
public class MarkAndToys {
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        List<Integer> priceList = Arrays.stream(prices).boxed().collect(Collectors.toList());
        Collections.sort(priceList);
        int count = 0;
        int tot = k;

        for (Integer price : priceList) {
            if (price <= tot) {
                tot = tot - price;
                count++;
            }
        }
        return count;
    }

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = bill.stream().mapToInt(Integer::intValue).sum();
        int sum_by_brian = sum / 2;
        int correct_sum = (sum - bill.get(k))/2;
        if (b == correct_sum) System.out.println("Bon Appetit");
        else System.out.println(Math.abs(sum_by_brian - b));
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
