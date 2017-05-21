package strings;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/pangrams
 */
public class Pangrams {

    public static final Set<Character> alphabet = IntStream.rangeClosed('a', 'z')
            .mapToObj(c -> (char) c)
            .collect(Collectors.toSet());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Set<Character> inputSet = input.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        if (inputSet.containsAll(alphabet))
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }
}
