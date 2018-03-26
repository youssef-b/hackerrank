package bitManipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/maximizing-xor/problem
 */
public class MaximizingXor {

    static int maximizingXor(int l, int r) {
        int maxXor = 0;
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                int xor = i ^ j;
                maxXor = Math.max(xor, maxXor);
            }
        }
        return maxXor;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int result = maximizingXor(l, r);
        System.out.println(result);
        in.close();
    }
}
