package sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort4
 */
public class CountingSort4 {

    static class ArrayElement {
        int x;
        String s;
        int initialIndex;

        public ArrayElement(int x, String s, int initialIndex) {
            this.x = x;
            this.s = s;
            this.initialIndex = initialIndex;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayElement arr[] = new ArrayElement[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayElement(in.nextInt(), in.next(), i);
        }
        sort(arr);
        StringBuilder output = new StringBuilder();
        int half =n/2;
        Arrays.stream(arr).forEach(e -> {
            if (e.initialIndex < half)
                output.append("- ");
            else
                output.append(e.s).append(" ");
        });
        System.out.printf(output.toString());
    }

    public static void sort(ArrayElement arr[]) {
        int n = arr.length;
        ArrayElement newArr[] = new ArrayElement[n];
        mergeSort(arr, newArr, 0, n - 1);
    }

    public static void mergeSort(ArrayElement arr[], ArrayElement newArr[], int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(arr, newArr, low, middle);
            mergeSort(arr, newArr, middle + 1, high);
            merge(arr, newArr, low, middle, high);
        }
    }

    private static void merge(ArrayElement arr[], ArrayElement newArr[], int low, int middle, int high) {

        System.arraycopy(arr, low, newArr, low, high + 1 - low);

        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (newArr[i].x <= newArr[j].x) {
                arr[k] = newArr[i];
                i++;
            } else {
                arr[k] = newArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = newArr[i];
            k++;
            i++;
        }
    }
}
