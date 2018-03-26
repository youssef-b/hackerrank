package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lilys-homework
 */
public class LilysHomework {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int arrA[] = new int[n];
        int arrD[] = new int[n];
        int arrS[] = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = in.nextInt();
            arrD[n - 1 - i] = arrA[i];
            arrS[i] = arrA[i];
        }
        Arrays.sort(arrS);

        long inversionsForAscendingOrder = getInversions(n, arrA, arrS);
        long inversionsForDescendingOrder = getInversions(n, arrD, arrS);

        System.out.println(Math.min(inversionsForAscendingOrder, inversionsForDescendingOrder));

    }

    private static long getInversions(int n, int[] arr, int[] arrS) {
        long inversions = 0;
        Map<Integer, Integer> mapValueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapValueToIndex.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != arrS[i]) {
                inversions += 1;
                int inversionIndex = mapValueToIndex.get(arrS[i]);
                mapValueToIndex.put(arr[i], inversionIndex);
                int temp = arr[i];
                arr[i] = arrS[i];
                arr[inversionIndex] = temp;
            }
        }
        return inversions;
    }

}
