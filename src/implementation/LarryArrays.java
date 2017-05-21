package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/larrys-array
 */
public class LarryArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 0; test < T; test++) {
            int N = sc.nextInt();

            int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            int inversionsCount = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (A[i] > A[j])
                        inversionsCount++;
                }
            }

            System.out.println((inversionsCount % 2 == 0) ? "YES" : "NO");
        }

    }
}
