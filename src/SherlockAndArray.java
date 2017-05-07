import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 */
public class SherlockAndArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int query = 0; query < t; query++) {
            int n = sc.nextInt();
            int[] sums = new int[n];
            sums[0] = sc.nextInt();
            for (int i = 1; i < n; i++) {
                sums[i] += sums[i - 1] + sc.nextInt();
            }
            boolean solutionExists = false;
            if (sums[n - 1] - sums[0] == 0)
                solutionExists = true;
            else {
                for (int i = 1; i < n; i++) {
                    if (sums[i - 1] == sums[n - 1] - sums[i]) {
                        solutionExists = true;
                        break;
                    }
                }
            }

            System.out.println(solutionExists ? "YES" : "NO");
        }
    }
}
