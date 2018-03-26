package bitManipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/and-product/problem
 */
public class AndProduct {
    static long andProduct(long a, long b) {
        long andProduct = a & b;
        long i = 1;
        for (; a + i < b; i *= 2) {
            andProduct = andProduct & (a + i);
        }
        return andProduct;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long result = andProduct(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
