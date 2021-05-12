package projectEuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by nethmih on 28.05.2020.
 */
public class NameScores_022 {

    private static char[] alphArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static int getIndex(char letter) {
        for (int index = 0; index < alphArray.length; index++)
            if (letter == alphArray[index]) { return index; }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<String> nameAry = new ArrayList<String>();
        for (int i=0; i< N; i++) {
            nameAry.add(in.next());
        }

        Collections.sort(nameAry);

        int nameCount = in.nextInt();
        for (int i=0; i< nameCount; i++) {
            String name = in.next();
            char[] blah = name.toLowerCase().toCharArray();

            int score = 0;
            for (char c : blah) {
                score = score + (getIndex(c) + 1);
            }

            score = score * (IntStream.range(0, nameAry.size())
                    .filter(z -> nameAry.get(z).toLowerCase().equals(name.toLowerCase()))
                    .findFirst().orElse(0) + 1);

            System.out.println(score);
        }

    }
}
