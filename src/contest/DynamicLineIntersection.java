package contest;

import java.util.*;

/**
 * https://www.hackerrank.com/contests/w37/challenges/dynamic-line-intersection
 */
public class DynamicLineIntersection {

    public static void dynamicLineIntersection(List<String> inputs) {

        Map<String, Line> lines = new HashMap<>();

        StringBuilder result = new StringBuilder();

        for (String input : inputs) {
            String[] inputArr = input.split(" ");
            if ("+".equals(inputArr[0])) {
                int k = Integer.valueOf(inputArr[1]);
                int b = Integer.valueOf(inputArr[2]);
                b=b%k;
                String key = k + ":" + b;
                Line line = lines.get(key);
                if (line == null)
                    lines.put(key, new Line(k, b));
                else
                    line.overlays++;
            } else if ("-".equals(inputArr[0])) {
                int k = Integer.valueOf(inputArr[1]);
                int b = Integer.valueOf(inputArr[2]);
                b=b%k;
                String key = k + ":" + b;
                lines.get(key).overlays--;
            } else if ("?".equals(inputArr[0])) {
                int q = Integer.valueOf(inputArr[1]);
                result.append(lines.values().parallelStream().mapToInt(line -> line.intersections(q)).sum()).append("\n");
            }
        }
        System.out.println(result.toString());
    }

    static class Line {
        int k, b;
        public int overlays = 1;

        public Line(int k, int b) {
            this.k = k;
            this.b = b;
        }

        public int intersections(int q) {
            return ((q - b) % k == 0)? overlays : 0;
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
