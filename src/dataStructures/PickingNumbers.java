package dataStructures;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by nethmih on 20.05.2020.
 */
public class PickingNumbers {


    static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int max_length = 0;
        int m = 0;
        if (a.get(a.size()-1) - a.get(0) == 0) return a.size();
        for (int i = 0; i < a.size() - 1; i++) {
            for(int j=i; j< a.size() - 1; j++) {
                if ((a.get(j + 1) - a.get(i)) <= 1) {
                    m++;
                } else {
                    if (max_length < m) {
                        max_length = m;
                    }
                    m = 0;
                    break;
                }
            }
        }
        return max_length > 0? max_length +1:max_length;

    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));


        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = pickingNumbers(a);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
