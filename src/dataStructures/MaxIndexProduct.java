package dataStructures;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by nethmih on 17.06.2020.
 */
public class MaxIndexProduct {
    static long solve(int[] arr) {
        Stack<Integer> st1=new Stack();
        Stack<Integer> st2=new Stack();
        int n=arr.length;
        int i;
        int left[]=new int[n];
        int right[]=new int[n];

        left[0]=0;
        st1.push(0);
        for(i=1;i<n;i++){
            while(!st1.isEmpty()&&arr[i]>=arr[st1.peek()]){
                st1.pop();
            }
            if(st1.isEmpty()) left[i]=0;
            else left[i]=st1.peek()+1;
            st1.push(i);
        }

        right[n-1]=0;
        st2.push(n-1);
        for(i=n-2;i>=0;i--){
            while(!st2.isEmpty()&&arr[i]>=arr[st2.peek()]){
                st2.pop();
            }
            if(st2.isEmpty()) right[i]=0;
            else right[i]=st2.peek()+1;
            st2.push(i);
        }
        long ans=0;

        for(i=0;i<n;i++){
            ans=Math.max(ans,(long)left[i]*right[i]);
        }
        return ans;
    }
    static long solve1(int[] arr) {
        long maxIndexProduct = 0;
        for (int i = 0; i < arr.length; i++) {
            // Get the slice of the Array
            int[] right_ary = Arrays.copyOfRange(arr, i + 1, arr.length);
            int[] left_ary = Arrays.copyOfRange(arr, 0, i);

       /*     System.out.println("LEFT Array");
            for(int h=0; h< left_ary.length; h++) {
                System.out.print(left_ary[h] + ", ");
            }
            System.out.println();

            System.out.println("RIGHT Array");
            for(int h=0; h< right_ary.length; h++) {
                System.out.print(right_ary[h] + ", ");
            }
            System.out.println();*/


            int right_index = getIndex(right_ary, arr[i]);
            if (right_index >= 0) right_index += 1 + i + 1;
            if (i == arr.length - 1) right_index = 0;

            int left_index = getIndex(IntStream.rangeClosed(1, left_ary.length).map(i1 -> left_ary[left_ary.length - i1]).toArray(), arr[i]);
            if (left_index >= 0) left_index = i - left_index;
            if (left_index < 0) left_index = 0;

            long prod = right_index * left_index;
        /*    System.out.println("i: " + i);
            System.out.println("left_index: " + left_index);
            System.out.println("right_index: " + right_index);*/
            if (prod > maxIndexProduct) maxIndexProduct = prod;

        }
        return maxIndexProduct;
    }

    static int getIndex(int[] subAry, int num) {
        for (int i = 0; i < subAry.length; i++) {
            if (subAry[i] > num) return i;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/nethmih/Documents/MSC projects/doc.txt"));


        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
