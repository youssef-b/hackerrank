package dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/substring-diff/problem
 */
public class SubstringDiff {
    /*
     * Complete the substringDiff function below.
     */
    static int substringDiff(int s, String p, String q) {
        int n = p.length();

        int[][] l = new int[n][n];

        int lMax = 0;

        for (int i = 0; i < n - lMax; i++) {
            for (int j = 0; j < n - lMax; j++) {
                int mismatches = 0;

                if (i > 0 && j > 0) {
                    l[i][j] = l[i - 1][j - 1] - 1;
                    mismatches = s - ((p.charAt(i - 1) == q.charAt(j - 1)) ? 0 : 1);
                }

                while (mismatches <= s && i + l[i][j] < n && j + l[i][j] < n) {
                    if (p.charAt(i + l[i][j]) != q.charAt(j + l[i][j])) {
                        mismatches++;
                    }
                    if (mismatches <= s)
                        l[i][j]++;
                }
                lMax = Math.max(lMax, l[i][j]);

            }
        }

        return lMax;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] spq = scanner.nextLine().split(" ");

            int s = Integer.parseInt(spq[0].trim());

            String p = spq[1];

            String q = spq[2];

            int result = substringDiff(s, p, q);

            System.out.println(result);
        }

    }
}

