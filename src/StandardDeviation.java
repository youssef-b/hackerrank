import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/s10-standard-deviation
 */
public class StandardDeviation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        Arrays.sort(x);
        double sd = standardDeviation(x);
        System.out.println(String.format("%.1f", sd));


    }

    private static double standardDeviation(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        double mean = Arrays.stream(arr).average().getAsDouble();
        return Math.sqrt(Arrays.stream(arr).mapToDouble(x -> (x - mean) * (x - mean)).average().getAsDouble());
    }


}
