package dataStructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by nethmih on 14.08.2020.
 */
public class LibFine {
    // Complete the libraryFine function below.
    // 1 return
    // 2 expected
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        if ((m2 > m1 && y1 == y2) || (y1 == y2 && m1 == m2 && d2 >= d1) || (y1 < y2)) return 0;
        else if (y1 == y2 && m1 == m2) return (d1 - d2) * 15;
        else if (y1 == y2) return (m1 - m2) * 500;
        else return 10000;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));

        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
