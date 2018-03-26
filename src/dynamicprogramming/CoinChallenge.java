package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/coin-change/problem
 */
public class CoinChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] coins = new long[m];

        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextLong();
        }
        Map<String, Long> memo = new HashMap<>();

        System.out.println(getWays(n, coins, m-1, memo));
    }

    public static long getWays(long total, long[] coins, int coinIndex, Map<String, Long> memo) {

        if (total == 0)
            return 1;
        else if (total < 0)
            return 0;
        else if (coinIndex < 0) {
            return 0;
        } else if (memo.get(total + ":" + coinIndex) != null) {
            return memo.get(total + ":" + coinIndex);
        } else {
            memo.put(total + ":" + coinIndex, getWays(total, coins, coinIndex - 1, memo) + getWays(total - coins[coinIndex], coins, coinIndex, memo));
            return memo.get(total + ":" + coinIndex);
        }
    }

}
