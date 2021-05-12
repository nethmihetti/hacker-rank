package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nethmih on 20.05.2020.
 */
public class JavaList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }
        int num_q = scan.nextInt();
        for (int j = 0; j < num_q; j++) {
            String q_type = scan.next();
            if (q_type.equals("Insert")) {
                int index = scan.nextInt();
                int value = scan.nextInt();
                list.add(index, value);
            } else if (q_type.equals("Delete")) {
                int del_value = scan.nextInt();
                list.remove(del_value);
            }
        }

        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }
}
