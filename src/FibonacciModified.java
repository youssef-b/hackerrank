import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */
public class FibonacciModified {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t0 = in.nextInt();
        int t1 = in.nextInt();
        int n = in.nextInt();
        BigInteger[] fib = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                fib[i] = BigInteger.valueOf(t0);
            else if (i == 1)
                fib[i] = BigInteger.valueOf(t1);
            else
                fib[i] = fib[i - 2].add(fib[i - 1].multiply(fib[i - 1]));
        }
        System.out.println(fib[n - 1]);

    }
}
