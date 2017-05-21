package ctci;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 */
public class BalancedBrackets {


    public static boolean isBalanced(String expression) {

        if (expression == null || expression.length() % 2 != 0)
            return false;

        Stack<Character> s = new Stack<>();
        for (char bracket : expression.toCharArray())
            switch (bracket) {
                case '{':
                    s.push('}');
                    break;
                case '(':
                    s.push(')');
                    break;
                case '[':
                    s.push(']');
                    break;
                default:
                    if (s.empty() || bracket != s.pop())
                        return false;
            }
        return s.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
