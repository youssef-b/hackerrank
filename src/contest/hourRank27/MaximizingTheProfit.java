package contest.hourRank27;

import java.util.Scanner;

/**
 *
 */
public class MaximizingTheProfit {

    /*
     * Complete the maximumProfit function below.
     */
    static long maximumProfit(int[] p) {
        long maxProfit = Integer.MIN_VALUE;
        int n = p.length;

        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                if (p[i] >= p[j]) continue;
                for (int k = j + 1; k < n; k++) {
                    if (p[j] >= p[k]) continue;
                    long profit = 1l*p[i] * p[j] * p[k];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }

        }
        return (maxProfit == Integer.MIN_VALUE)?-1:maxProfit;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }

        System.out.println(maximumProfit(p));
    }
}
