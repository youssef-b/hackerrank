import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/maximum-subarray-sum
 */
public class MaximumSubArraySum {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        for (int query = 0; query < q; query++) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            long[] sumModulo = new long[n];
            TreeSet<Long> tree = new TreeSet<>();

            sumModulo[0] = (sc.nextLong()) % m;
            tree.add(sumModulo[0]);
            long maxSubSumModulo = sumModulo[0];
            for (int i = 1; i < n; i++) {
                sumModulo[i] = (sumModulo[i - 1] + sc.nextLong()) % m;
                long optimalSubSum = 0;
                try {
                    optimalSubSum = tree.higher(sumModulo[i]);
                } catch (Exception e) {
                }
                maxSubSumModulo = Math.max(sumModulo[i], maxSubSumModulo);
                maxSubSumModulo = Math.max((sumModulo[i] - optimalSubSum + m) % m, maxSubSumModulo);
                tree.add(sumModulo[i]);
            }

            System.out.println(maxSubSumModulo);
        }

    }
}
