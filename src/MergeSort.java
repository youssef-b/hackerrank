import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-merge-sort
 */
public class MergeSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            long inversions = sort(arr);
            System.out.println(inversions);
        }
    }

    public static long sort(int[] arr) {
        int n = arr.length;
        int newArr[] = new int[n];
        return mergeSort(arr, newArr, 0, n - 1);
    }

    public static long mergeSort(int arr[], int newArr[], int low, int high) {
        long inversions = 0;
        if (low < high) {
            int middle = low + (high - low) / 2;
            inversions += mergeSort(arr, newArr, low, middle);
            inversions += mergeSort(arr, newArr, middle + 1, high);
            inversions += merge(arr, newArr, low, middle, high);
        }
        return inversions;
    }

    private static long merge(int arr[], int newArr[], int low, int middle, int high) {

        long inversions = 0;
        for (int i = low; i <= high; i++) {
            newArr[i] = arr[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (newArr[i] <= newArr[j]) {
                arr[k] = newArr[i];
                i++;
            } else {
                arr[k] = newArr[j];
                inversions += j - k;
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = newArr[i];
            k++;
            i++;
        }

        return inversions;

    }

}
