package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-children
 */
public class AngryChildren {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        int minimumUnfairness = numbers[k - 1] - numbers[0];

        for (int i = 1; i < n - k + 1; i++) {
            minimumUnfairness = Math.min(minimumUnfairness, numbers[k - 1 + i] - numbers[i]);
        }

        sc.close();

        System.out.println(minimumUnfairness);
    }
}
