package datastructures;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/2d-array
 */
public class ArrayDS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int arr_i = 0; arr_i < 6; arr_i++) {
            for (int arr_j = 0; arr_j < 6; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        int maxHourGlassSum = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int hgSum = calculateHourGlassSum(arr, i, j);
                maxHourGlassSum = (hgSum > maxHourGlassSum) ? hgSum : maxHourGlassSum;
            }
        }
        System.out.println(maxHourGlassSum);
    }


    public static int calculateHourGlassSum(int arr[][], int iOrigin, int jOrigin) {
        int sum = 0;
        for (int i = iOrigin; i < iOrigin + 3; i++) {
            for (int j = jOrigin; j < jOrigin + 3; j++) {
                if (!(i == iOrigin + 1 && (j == jOrigin || j == jOrigin + 2)))
                    sum = sum + arr[i][j];

            }
        }
        return sum;
    }
}