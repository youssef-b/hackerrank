package recursion;

import java.util.Scanner;

/**
 * Created by youssef on 26/03/18.
 */
public class PowerSum {

    /**
     * number of possible power N sum of X using numbers equal or greater than num
     */
    static int powerSum(int X, int N, int num) {
        if (Math.pow(num, N) < X)
            return powerSum(X, N, num + 1) + powerSum(X - (int) Math.pow(num, N), N, num + 1);
        else if (Math.pow(num, N) == X)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int result = powerSum(X, N, 1);
        System.out.println(result);
        in.close();
    }
}
