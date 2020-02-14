package statistics;

/**
 *
 */
public class binomialDistribution2 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        double p = 0.12;
        double q = 1-p;
        int n =10;
        int[] fact = new int[n+1];

        int x = 0;
        double rejects0=Math.pow(p,x)*Math.pow(q,n-x)*factorial(fact,n)/(factorial(fact,x)*factorial(fact,n-x));

        x = 1;
        double rejects1=Math.pow(p,x)*Math.pow(q,n-x)*factorial(fact,n)/(factorial(fact,x)*factorial(fact,n-x));

        x = 2;
        double rejects2=Math.pow(p,x)*Math.pow(q,n-x)*factorial(fact,n)/(factorial(fact,x)*factorial(fact,n-x));

        double noMoreThanTwoRejects2= rejects0 + rejects1 + rejects2;
        System.out.println(String.format("%.3f",noMoreThanTwoRejects2));


        double atLeastTwoRejects2 = 1 - rejects0 - rejects1;
        System.out.println(String.format("%.3f", atLeastTwoRejects2));


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