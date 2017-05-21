package ctci;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 */
public class RunningMedium {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int element1 = a[0];
        int element2 = a[1];

        printMedium(element1);
        printMedium(((double) (element1 + element2)) / 2);
        updateHeaps(minHeap, maxHeap, element1, element2);
        int minHeapHead = Math.max(element1, element2);
        int maxHeapHead = Math.min(element1, element2);
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0) {
                element1 = a[i];
                printMedium(Math.max(maxHeapHead,Math.min(minHeapHead,element1)));
            } else {
                element2 = a[i];
                minHeapHead = minHeap.poll();
                maxHeapHead = maxHeap.poll();
                updateHeaps(minHeap, maxHeap, minHeapHead, maxHeapHead, element1, element2);
                minHeapHead = minHeap.peek();
                maxHeapHead = maxHeap.peek();
                printMedium(((double) (minHeapHead + maxHeapHead)) / 2);


            }

        }
    }

    private static void printMedium(double medium) {
        System.out.println(String.format("%.1f", medium));
    }

    private static void updateHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap,
                                    int minHeapHead, int maxHeapHead, int element1, int element2) {
        int[] arr = new int[]{minHeapHead, maxHeapHead, element1, element2};
        Arrays.sort(arr);
        maxHeap.add(arr[0]);
        maxHeap.add(arr[1]);
        minHeap.add(arr[2]);
        minHeap.add(arr[3]);
    }

    private static void updateHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap,
                                    int element1, int element2) {
        maxHeap.add(Math.min(element1, element2));
        minHeap.add(Math.max(element1, element2));
    }
}
