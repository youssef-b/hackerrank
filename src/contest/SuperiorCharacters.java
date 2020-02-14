package contest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w37/challenges/superior-characters
 */
public class SuperiorCharacters {
    // Complete the maximumSuperiorCharacters function below.
    static long maximumSuperiorCharacters(int[] freq) {


        long CharsCount = Arrays.stream(freq).asLongStream().sum();
        long supCharsCountLimit = (CharsCount - 1) / 2;

        long infCharsCount = 0;
        int middleChar;
        for (middleChar = 0; infCharsCount <= CharsCount - supCharsCountLimit && middleChar < freq.length; middleChar++) {
            infCharsCount += freq[middleChar];
        }
        long middleCharCount = supCharsCountLimit + infCharsCount - CharsCount;
        middleChar--;
        infCharsCount -= freq[middleChar];


        long matchedSupCount = Math.min(middleCharCount, Math.max(infCharsCount - 1, 0));
        return supCharsCountLimit - (middleCharCount - matchedSupCount);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        for (int tItr = 0; tItr < t; tItr++) {
            int[] freq = new int[26];

            for (int freqItr = 0; freqItr < 26; freqItr++) {
                int freqItem = scanner.nextInt();
                freq[freqItr] = freqItem;
            }
            long result = maximumSuperiorCharacters(freq);

            System.out.println((String.valueOf(result)));
        }
        scanner.close();
    }
}
