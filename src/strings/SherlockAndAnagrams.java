package strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 */
public class SherlockAndAnagrams {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int query = 0; query < t; query++) {
            String s = sc.next();
            int len= s.length();
            int countAnagramPairs = 0;

            for (int l = 1; l < len; l++) {
                for (int i = 0; i <=len-l; i++) {
                    String s1 = s.substring(i,i+l);
                    for (int j = i+1; j <= len-l; j++) {
                        String s2 = s.substring(j,j+l);
                        countAnagramPairs += checkAnagrams(s1,s2)?1:0;

                    }

                }

            }

            System.out.println(countAnagramPairs);
        }
    }

    private static boolean checkAnagrams(String first, String second) {

        int[] alphabetFrequency = new int[26];
        for (char c : first.toCharArray())
            alphabetFrequency[((int) c - 97)] += 1;

        for (char c : second.toCharArray())
            alphabetFrequency[((int) c - 97)] -= 1;

        int numberNeeded = 0;
        for (int i = 0; i < 26; i++) {
            numberNeeded += Math.abs(alphabetFrequency[i]);
        }

        return (numberNeeded>0)?false:true;
    }
}
