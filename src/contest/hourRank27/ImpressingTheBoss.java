package contest.hourRank27;

import java.util.Scanner;

/**
 *
 */
public class ImpressingTheBoss {
    /*
     * Complete the canModify function below.
     */
    static String canModify(int[] a) {
        int modificationCount = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                if( (i == 1) || ( a[i-2] <= a[i])){
                    a[i-1] = a[i];
                    modificationCount++;
                }
                else {
                    a[i] = a[i-1];
                    modificationCount++;
                }
            }
        }

        return (modificationCount < 2) ? "YES" : "NO";
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }

            String result = canModify(arr);
            System.out.println(result);
        }

    }
}
