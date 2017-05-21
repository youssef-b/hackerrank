package ctci;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 */
public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int[] alphabetFrequency = new int[26];
        for (char c : first.toCharArray())
            alphabetFrequency[((int) c - 97)] += 1;

        for (char c : second.toCharArray())
            alphabetFrequency[((int) c - 97)] -= 1;

        int numberNeeded = 0;
        for (int i = 0; i < 26; i++) {
            numberNeeded += Math.abs(alphabetFrequency[i]);
        }

        return numberNeeded;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
