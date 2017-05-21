package ctci;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-coin-change
 * explanation: https://www.youtube.com/watch?v=ZaVM057DuzE
 */
public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }

        System.out.println(changeWays(n, coins));
    }

    private static long changeWays(int n, int[] coins) {

        long changeWays[] = new long[n + 1];
        changeWays[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                changeWays[i] += changeWays[i - coin];
            }
        }
        return changeWays[n];
    }
}