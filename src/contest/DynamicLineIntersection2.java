package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w37/challenges/dynamic-line-intersection
 */
public class DynamicLineIntersection2 {

    // Complete the maximumSuperiorCharacters function below.
    static void dynamicLineIntersection(List<String> inputs) {

        int qmax = 100001;
        int[] intersections = new int[qmax + 1];
        for (String input : inputs) {
            if ("+".equalsIgnoreCase(input.substring(0, 1))) {
                int k = Integer.valueOf(input.substring(2, 3));
                int b = Integer.valueOf(input.substring(4, 5));
                for (int j = (-b / k) - 1; b + j * k <= qmax; j++) {
                    if (b + j * k >= 0)
                        intersections[b + j * k] += 1;
                }
            } else if ("-".equalsIgnoreCase(input.substring(0, 1))) {
                int k = Integer.valueOf(input.substring(2, 3));
                int b = Integer.valueOf(input.substring(4, 5));
                for (int j = (-b / k) - 1; b + j * k <= qmax; j++) {
                    if (b + j * k >= 0)
                        intersections[b + j * k] -= 1;
                }


            } else if ("?".equalsIgnoreCase(input.substring(0, 1))) {
                int q = Integer.valueOf(input.substring(2, 3));
                System.out.println(intersections[q]);
            }

        }

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());

        }
        scanner.close();
        dynamicLineIntersection(inputs);

    }
}