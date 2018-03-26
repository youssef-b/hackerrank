package dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-cost/problem
 */
public class SherlockAndCost {


    static int cost(int[] arr) {
        int n = arr.length;
        int[][] memo = new int[2][n];
        for (int i = 1; i < arr.length; i++) {
            int diff1 = Math.abs(arr[i] - arr[i - 1]) + memo[0][i - 1];
            int diff2 = Math.abs(arr[i] - 1) + memo[1][i - 1];
            memo[0][i] = Math.max(diff1, diff2);
            memo[1][i] = memo[0][i - 1] + Math.abs(1 - arr[i - 1]);
        }
        return Math.max(memo[0][n - 1], memo[1][n - 1]);
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
            int result = cost(arr);
            System.out.println(result);
        }
        in.close();
    }
}
