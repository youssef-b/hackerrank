package contest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w37/challenges/z-function/problem
 */
public class ZFunction {
    /*
     * Complete the zFunction function below.
     */

    public static final long MOD = 1000000007;
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+-=";

    static int zFunction(int n, int k) {


        char[] chars = ALPHABET.substring(0, k).toCharArray();
        Arrays.sort(chars);
        long[] result = new long[1];

        String res = "ab";
        permutations(chars, n, res, result);

        result[0] = (result[0] * (k - 1)) % MOD;
        res = "aa";
        permutations(chars, n, res, result);
        result[0] = (result[0] * k) % MOD;

        return (int) result[0];

    }

    public static void permutations(char[] str, int n, String res, long[] result) {


        if (res.length() == n) {
            int[] zArr = getZarr(res);
            int z = Arrays.stream(zArr).max().getAsInt();
            result[0] = (result[0] + z) % MOD;
            return;
        }

        for (int i = 0; i < str.length; i++) {
            permutations(str, n, res + str[i], result);
        }
    }

    static int[] getZarr(String str) {
        int n = str.length();
        int[] z = new int[n];

        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && str.charAt(R - L) == str.charAt(R)) R++;
                z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (z[k] < R - i + 1) z[i] = z[k];
                else {
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R)) R++;
                    z[i] = R - L;
                    R--;
                }
            }
        }
        z[0] = -1;

        return z;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int n = scanner.nextInt();

        int k = scanner.nextInt();

        int result = zFunction(n, k);

        System.out.println((String.valueOf(result)));


        scanner.close();
    }
}


