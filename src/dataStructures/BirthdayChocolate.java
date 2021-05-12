package dataStructures;

import java.io.*;
import java.util.*;

/**
 * Created by nethmih on 20.05.2020.
 */
public class BirthdayChocolate {

    static int sumArray(List<Integer> s) {
        int sum = 0;
        for (Integer integer : s) {
            sum += integer;
        }
        return sum;
    };

    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        if(s.size() < m) return count;

        for(int i=0; i<(s.size()-m+1); i++) {
            int sum = sumArray(s.subList(i, (m + i)));
            // sum without looping
            int a = s.stream().mapToInt(Integer::intValue).sum();
            if (sum == d) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] sItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sItems[i]);
            s.add(sItem);
        }

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
