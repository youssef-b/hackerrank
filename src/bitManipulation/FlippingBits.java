package bitManipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-bits/problem
 */
public class FlippingBits {

    static long flippingBits(long N) {
        return N ^ ((1l << 32) - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int a0 = 0; a0 < T; a0++) {
            long N = in.nextLong();
            long result = flippingBits(N);
            System.out.println(result);
        }
        in.close();
    }
}
