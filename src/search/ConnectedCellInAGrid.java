package search;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 */
public class ConnectedCellInAGrid {

    public static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }

        }
        int numberCellsLargestRegion = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int numberCells = numberCellsRegion(matrix, visited, i, j);
                numberCellsLargestRegion = Math.max(numberCellsLargestRegion, numberCells);

            }
        }
        System.out.println(numberCellsLargestRegion);
    }

    private static int numberCellsRegion(int[][] matrix, int[][] visited, int i, int j) {
        int numberCells = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        if (visited[i][j] == 1 || matrix[i][j] == 0) {
            visited[i][j] = 1;
            return 0;
        }
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(i, j));
        while (!stack.isEmpty()) {
            Cell currentCell = stack.pop();
            int x = currentCell.x;
            int y = currentCell.y;
            if (visited[x][y] != 1) {
                visited[x][y] = 1;

                if (matrix[x][y] == 1) {
                    numberCells += 1;

                    if (x - 1 >= 0 && y - 1 >= 0) {
                        stack.push(new Cell(x - 1, y - 1));
                    }
                    if (x - 1 >= 0) {
                        stack.push(new Cell(x - 1, y));
                    }
                    if (x - 1 >= 0 && y + 1 < m) {
                        stack.push(new Cell(x - 1, y + 1));
                    }
                    if (y - 1 >= 0) {
                        stack.push(new Cell(x, y - 1));
                    }
                    if (y + 1 < m) {
                        stack.push(new Cell(x, y + 1));
                    }
                    if (x + 1 < n && y - 1 >= 0) {
                        stack.push(new Cell(x + 1, y - 1));
                    }
                    if (x + 1 < n) {
                        stack.push(new Cell(x + 1, y));
                    }
                    if (x + 1 < n && y + 1 < m) {
                        stack.push(new Cell(x + 1, y + 1));
                    }
                }
            }
        }
        return numberCells;
    }

}
