package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/candies/problem
 */
public class Candies {

    static long candies(int n, int[] arr) {
        long[] candies = new long[n];
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1])
                candies[i] = candies[i - 1] + 1;
            else
                candies[i] = 1;
        }
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i] && candies[i - 1] <= candies[i])
                candies[i - 1] = candies[i] + 1;
        }
        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        System.out.println(candies(n, arr));
        in.close();
    }
}
