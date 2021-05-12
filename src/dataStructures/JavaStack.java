package dataStructures;

import java.util.*;

/**
 * Created by nethmih on 14.07.2020.
 */
public class JavaStack {

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> stck = new Stack<>();

        while (sc.hasNext()) {
            String input=sc.next();
            char[] ary = input.toCharArray();
            for (char c : ary) {
                if(c == '{' || c == '(' || c == '[') {
                    stck.push(Character.toString(c));
                    continue;
                }
                if(c == '}' && !stck.isEmpty() && stck.peek().equals("{")) {
                    stck.pop();
                    continue;
                }
                if(c == ')' && !stck.isEmpty() && stck.peek().equals("(")) {
                    stck.pop();
                    continue;
                }
                if(c == ']' && !stck.isEmpty() && stck.peek().equals("[")) {
                    stck.pop();
                    continue;
                }
                if(c == '}' || c == ')' || c == ']') {
                    stck.push(Character.toString(c));
                    break;
                }
            }
            System.out.println(stck.isEmpty());
        }

    }
}
