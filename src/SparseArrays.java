import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays
 */
public class SparseArrays {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        List<String> sList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            sList.add(in.next().trim());

        }
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            String input = in.next().trim();
            System.out.println(Collections.frequency(sList, input));
        }


    }

}
