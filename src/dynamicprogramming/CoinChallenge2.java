package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CoinChallenge2 {

    public static void main(String[] args) {
        long[] coins = new long[]{100,50,25,10,5,1};
        Map<String, String> memo = new HashMap<>();
        for (int i = 1; i <= 101; i++) {
            System.out.println("" +i+ " : " +getWays(100, coins,i, memo,""));
        }

    }

    public static long getWays(long total, long[] coins, int coinsNumber, Map<String, String> memo, String sequence) {

        if (total == 0 && coinsNumber ==0){
            System.out.println(sequence);
            return 1;
        }

        else if (total <= 0)
            return 0;
        else if (coinsNumber <= 0) {
            return 0;
        } else {
            long ways = 0;
            for (long coin:coins){
                ways += getWays(total - coin, coins, coinsNumber-1, memo,sequence + ":"+coin);
                if (ways > 0) break;
            }
            return ways;
        }
    }

}
