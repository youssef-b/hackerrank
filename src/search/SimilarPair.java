package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/similarpair
 */
public class SimilarPair {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>(n);
        int similar = 0;

        for (int i = 0; i < n - 1; i++) {
            int pData = sc.nextInt();
            int cData = sc.nextInt();
            map.put(cData, pData);


            int currData = cData;
            while (map.get(currData) != null) {

                int ancestorData = map.get(currData);

                if (Math.abs(ancestorData - cData) <= k) {
                    similar += 1;
                }

                currData = ancestorData;
            }
        }
        sc.close();

        System.out.println(similar);
    }
}