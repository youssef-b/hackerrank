package search;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/missing-numbers
 */
public class MissingNumbers {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <n ; i++) {
            a[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i <m ; i++) {
            b[i] = in.nextInt();
        }
        IntSummaryStatistics bStats = Arrays.stream(b).summaryStatistics();
        int bMin = bStats.getMin();
        int bMax = bStats.getMax();
        int[] bHistogram = new int[bMax-bMin+1];
        for (int i = 0; i <m ; i++) {
            int indexHist = b[i]-bMin;
            bHistogram[indexHist]++;
        }

        for (int i = 0; i <n ; i++) {
            int indexHist = a[i]-bMin;
            bHistogram[indexHist]--;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <bMax-bMin+1 ; i++) {
            if (bHistogram[i] > 0) {
                result.append(bMin+i).append(" ");
            }
        }
        System.out.println(result.toString().trim());

    }
}
