import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/s10-quartiles
 */
public class Quartiles {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        Arrays.sort(x);
        double Q2 = median(x, 0, n - 1);
        double Q1;
        double Q3;
        if (n > 0 && n % 2 == 0) {
            Q1 = median(x, 0, n / 2 - 1);
            Q3 = median(x, n / 2, n - 1);
        } else {
            Q1 = median(x, 0, n / 2 - 1);
            Q3 = median(x, n / 2 + 1, n - 1);
        }

        sc.close();
        System.out.println(String.format("%.0f", Q1));
        System.out.println(String.format("%.0f", Q2));
        System.out.println(String.format("%.0f", Q3));


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
