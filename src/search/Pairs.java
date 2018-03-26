package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pairs
 */
public class Pairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        map.put(sc.nextInt(), 1);

        for (int i = 1; i < n; i++) {
            int number = sc.nextInt();
            pairs += getOccurrence(map,number-k)+getOccurrence(map,number+k);
            map.put(number, getOccurrence(map, number) + 1);
        }
        sc.close();

        System.out.println(pairs);
    }

    private static int getOccurrence(Map<Integer, Integer> map, int number) {
        return map.get(number) == null ? 0 : map.get(number);
    }

}
