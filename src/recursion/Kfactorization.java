package recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/k-factorization/problem
 */
public class Kfactorization {

    static int[] kFactorization(int n, int[] A) {


        String currentFact = "1";

        String optimalFact = optimalFactorization(n, A, 0, currentFact);

        int[] fact = Arrays.stream(optimalFact.split(":")).mapToInt(s -> Integer.valueOf(s)).toArray();
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i] * fact[i - 1];
        }
        return fact;
    }

    private static String optimalFactorization(int n, int[] A, int indexA, String currentFact) {

        if (indexA >= A.length) {
            return "-1";
        }
        int remainder = n % A[indexA];
        int quotient = n / A[indexA];
        if (n == A[indexA]) {
            currentFact = currentFact + ":" + A[indexA];
            return currentFact;
        } else if (remainder == 0) {
            String fact1 = optimalFactorization(quotient, A, indexA, currentFact + ":" + A[indexA]);
            String fact2 = optimalFactorization(n, A, indexA + 1, currentFact);
            return getOptimalFact(fact1, fact2);
        } else {
            return optimalFactorization(n, A, indexA + 1, currentFact);
        }
    }

    private static String getOptimalFact(String fact1, String fact2) {
        if ("-1".equals(fact2))
            return fact1;
        if ("-1".equals(fact1))
            return fact2;
        else if (fact1.length() < fact2.length())
            return fact1;
        else if (fact1.length() == fact2.length() && fact1.compareTo(fact2) <= 0)
            return fact1;
        else
            return fact2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] A = new int[k];
        for (int A_i = 0; A_i < k; A_i++) {
            A[A_i] = in.nextInt();
        }
        int[] result = kFactorization(n, A);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
