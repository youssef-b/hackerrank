package dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maxsubarray/problem
 */
public class MaxSubarray {

    static int[] maxSubarray(int[] arr) {
        int[] maxSubarray = new int[2];

        int max = arr[0];
        int curr_max = arr[0];
        maxSubarray[0] = arr[0];
        maxSubarray[1] += Math.max(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            max = Math.max(arr[i], max);
            maxSubarray[0] = Math.max(maxSubarray[0], curr_max);
            maxSubarray[1] += Math.max(arr[i], 0);
        }
        if (max < 0)
            maxSubarray[1] = max;

        return maxSubarray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int[] result = maxSubarray(arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
