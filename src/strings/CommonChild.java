package strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/common-child
 */
public class CommonChild {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        int n = a.length();
        int[][] L = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(a.charAt(i)==b.charAt(j))
                    L[i+1][j+1] = L[i][j]+1;
                else
                    L[i+1][j+1] = Math.max(L[i+1][j], L[i][j+1]);
            }
        }
        System.out.println(L[n][n]);
    }
}
