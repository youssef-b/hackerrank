import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation
 */
public class LeftRotation {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[(i + n - d) % n] = in.nextInt();

        }
        String out = Arrays.stream(arr).mapToObj(x -> "" + x).collect(Collectors.joining(" "));
        System.out.println(out);

    }

}
