package statistics;

/**
 * Created by youssef on 22/04/2018.
 */
public class PoissonDistribution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        double e = 2.71828;
        double l = 2.5;
        int k = 5;
        int[] fact = new int[k + 1];
        double result = Math.pow(l, k) * Math.pow(e, -l) / factorial(fact, k);
        System.out.println(String.format("%.3f", result));


    }

    public static int factorial(int[] fact, int n) {
        if (fact[n] != 0)
            return fact[n];
        else if (n == 0 || n == 1) {
            fact[n] = 1;
            return fact[n];
        } else {
            fact[n] = factorial(fact, n - 1) * n;
            return fact[n];
        }
    }
}