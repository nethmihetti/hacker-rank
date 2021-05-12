package dataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by nethmih on 14.07.2020.
 */
public class JavaMap {
    public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();

        HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();

        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            Integer num = phoneBook.get(s);
            if(num!=null) System.out.println(s+"="+num);
            else System.out.println("Not found");
        }
    }
}
