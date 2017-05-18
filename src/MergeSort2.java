import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort
 */
public class MergeSort2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long inversions = getInversionsNumber(arr);
            System.out.println(inversions);
        }
    }

    private static long getInversionsNumber(int[] arr) {
        long inversions =0;
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int fenwickTree[] = new int[max+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = arr[i]-1; j >=0; ) {
                inversions += fenwickTree[j];
                j = (j & (j + 1)) - 1;
            }
            for (int j = arr[i]; j < fenwickTree.length;) {
                fenwickTree[j] += 1;
                j |= j + 1;
            }
        }

        return inversions;
    }
}

