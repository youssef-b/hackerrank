package statistics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/s10-interquartile-range
 */
public class Interquartile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] f = new int[n];
        int fn = 0;
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
            fn += f[i];
        }

        int[] s = IntStream.range(0,n).flatMap(i-> Collections.nCopies(f[i],x[i]).stream().mapToInt(j->j)).toArray();

        Arrays.sort(s);
        double Q1;
        double Q3;
        if (fn > 0 && fn % 2 == 0) {
            Q1 = median(s, 0, fn / 2 - 1);
            Q3 = median(s, fn / 2, fn - 1);
        } else {
            Q1 = median(s, 0, fn / 2 - 1);
            Q3 = median(s, fn / 2 + 1, fn - 1);
        }

        sc.close();
        System.out.println(String.format("%.1f", Q3-Q1));


    }

    public static double median(int[] arr, int start, int end) {
        double median;
        int n = end - start + 1;
        if (n > 0 && n % 2 == 0)
            median = 0.5 * (arr[start + n / 2 - 1] + arr[start + n / 2]);
        else
            median = arr[start + n / 2];

        return median;
    }


}
