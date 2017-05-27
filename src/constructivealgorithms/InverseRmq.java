package constructivealgorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/inverse-rmq
 */
public class InverseRmq {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            arr[i] = in.nextInt();
        }

        boolean possible = restoreST(n, arr);
        if (possible) {
            System.out.println("YES");
            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        } else
            System.out.println("NO");


    }

    private static boolean restoreST(int n, int[] arr) {
        if (n == 1)
            return true;

        Map<Integer, Long> frequencies = Arrays.stream(arr).mapToObj(x -> x).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        if (frequencies.size() != n)
            return false;

        int highestFrequency = 1;
        int n1 = n;
        while (n1 > 1) {
            highestFrequency++;
            n1 >>= 1;
        }

        // indexed by element frequency.
        TreeSet<Integer>[] elementsInFrequency = new TreeSet[highestFrequency - 1];

        int root = Integer.MIN_VALUE;
        for (Integer key : frequencies.keySet()) {
            final int frequency = (int) (frequencies.get(key).longValue());
            if (frequency > highestFrequency)
                return false;
            else if (frequency == highestFrequency) {
                root = key;
            } else {
                if (elementsInFrequency[frequency - 1] == null)
                    elementsInFrequency[frequency - 1] = new TreeSet<>();
                elementsInFrequency[frequency - 1].add(key);
            }
        }

        if (root == Integer.MIN_VALUE)
            return false;

        int index = 0;
        int key = root;
        int frequency = highestFrequency - 2;
        int expectedNbElementsInFrequency = 1;
        int elementsProcessedInFrequency = 0;
        while (index < 2 * n) {

            int j = index;
            while (j < 2 * n - 1) {
                arr[j] = key;
                j = 2 * j + 1;
            }
            index += 2;
            if (index < 2 * n) {
                if (frequency < 0)
                    return false;
                if (elementsInFrequency[frequency] == null)
                    return false;
                Integer newKey = elementsInFrequency[frequency].higher(arr[index - 1]);
                if (newKey == null)
                    return false;
                elementsInFrequency[frequency].remove(newKey);
                key = newKey;
                elementsProcessedInFrequency++;
                if (elementsProcessedInFrequency == expectedNbElementsInFrequency) {
                    elementsProcessedInFrequency = 0;
                    expectedNbElementsInFrequency *= 2;
                    frequency--;
                }
            }
        }

        if (index != 2 * n)
            return false;

        return true;
    }
}
