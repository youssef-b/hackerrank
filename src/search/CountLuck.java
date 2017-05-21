package search;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/count-luck
 */
public class CountLuck {

    public static class Cell {
        int x, y, handWavesNbSoFar;

        public Cell(int x, int y, int handWavesNbSoFar) {
            this.x = x;
            this.y = y;
            this.handWavesNbSoFar = handWavesNbSoFar;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            int xStart = 0, yStart = 0;
            char[] line;
            char[][] matrix = new char[n][m];
            int[][] visited = new int[n][m];
            for (int i = 0; i < n; i++) {
                line = in.nextLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = line[j];
                    if ('M' == line[j]) {
                        xStart = i;
                        yStart = j;
                    }
                }

            }
            int k = in.nextInt();
            int handWavesNb = handWavesNumber(matrix, visited, xStart, yStart);
            System.out.println((handWavesNb == k) ? "Impressed" : "Oops!");
        }

    }

    private static int handWavesNumber(char[][] matrix, int[][] visited, int xStart, int yStart) {
        int handWavesNb = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(xStart, yStart, 0));
        while (!stack.isEmpty()) {
            Cell currentCell = stack.pop();
            int x = currentCell.x;
            int y = currentCell.y;

            handWavesNb = currentCell.handWavesNbSoFar;

            int choiceNb = getChoiceNumber(matrix, visited, x, y);
            if (choiceNb < 0)
                return handWavesNb;
            else if (choiceNb >= 1) {
                if (choiceNb > 1)
                    handWavesNb++;

                if (x - 1 >= 0) {
                    if(processCell(matrix, visited, stack, handWavesNb, x - 1, y)) return handWavesNb;
                }
                if (x + 1 < n) {
                    if(processCell(matrix, visited, stack, handWavesNb, x + 1, y)) return handWavesNb;
                }
                if (y - 1 >= 0) {
                    if(processCell(matrix, visited, stack, handWavesNb, x, y - 1)) return handWavesNb;
                }
                if (y + 1 < m) {
                    if(processCell(matrix, visited, stack, handWavesNb, x, y + 1)) return handWavesNb;
                }
            }
        }
        return handWavesNb;
    }

    private static boolean processCell(char[][] matrix, int[][] visited, Stack<Cell> stack, int handWavesNb, int x, int y) {
        if ('.' == matrix[x][y] && visited[x][y] != 1) {
            visited[x][y] = 1;
            stack.push(new Cell(x, y, handWavesNb));
        }
        else if ('*' == matrix[x][y])
            return true;
        return false;
    }

    private static int getChoiceNumber(char[][] matrix, int[][] visited, int x, int y) {

        int choiceNb = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        if (x - 1 >= 0 && visited[x - 1][y] != 1) {
            if ('.' == matrix[x - 1][y] || '*' == matrix[x - 1][y])
                choiceNb++;
        }
        if (x + 1 < n && visited[x + 1][y] != 1) {
            if ('.' == matrix[x + 1][y] || '*' == matrix[x + 1][y])
                choiceNb++;
        }
        if (y - 1 >= 0 && visited[x][y - 1] != 1) {
            if ('.' == matrix[x][y - 1] || '*' == matrix[x][y - 1])
                choiceNb++;
        }
        if (y + 1 < m && visited[x][y + 1] != 1) {
            if ('.' == matrix[x][y + 1] || '*' == matrix[x][y + 1])
                choiceNb++;
        }
        return choiceNb;
    }

}
