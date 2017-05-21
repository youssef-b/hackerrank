package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/greedy-florist
 */
public class GreedyFlorist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        Arrays.sort(prices);
        int minimumCost = 0;

        int i = n - 1;
        int x = 0;
        while (i >= 0) {
            for (int j = i; j >= Math.max(0, i - k + 1); j--) {
                minimumCost += (x + 1) * prices[j];
            }
            i = i - k;
            x++;
        }
        sc.close();

        System.out.println(minimumCost);
    }

}
