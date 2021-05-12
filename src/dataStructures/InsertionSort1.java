package dataStructures;

import java.util.Scanner;

/**
 * Created by nethmih on 20.08.2020.
 */
public class InsertionSort1 {
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int val = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > val) {
                arr[i + 1] = arr[i];
                printAry(arr);
                if(i==0) {
                    arr[i] = val;
                    printAry(arr);
                }
            } else {
                arr[i+1] = val;
                printAry(arr);
                break;
            }
        }
    }

    static void printAry(int[] arr) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
