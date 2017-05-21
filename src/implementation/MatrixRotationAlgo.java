package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 */
public class MatrixRotationAlgo {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int r = s.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
        }

        List<Integer> layer = new ArrayList<>();
        int iStart = 0;
        int iEnd = m - 1;
        int jStart = 0;
        int jEnd = n - 1;
        while (iEnd - iStart + 1 > 0 && jEnd - jStart + 1 > 0) {
            extractMatrixLayer(a, layer, iStart, iEnd, jStart, jEnd);
            Collections.rotate(layer, r % layer.size());
            updateMatrixLayer(a, layer, iStart, iEnd, jStart, jEnd);
            layer.clear();
            iStart++;
            iEnd--;
            jStart++;
            jEnd--;
        }
        for (int[] row : a) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static void updateMatrixLayer(int[][] a, List<Integer> layer, int iStart, int iEnd, int jStart, int jEnd) {
        int i= iStart;
        int j= jStart;
        int k = 0;
        for (; i < iEnd; i++)
            a[i][j] = layer.get(k++);
        for (; j < jEnd; j++)
            a[i][j] = layer.get(k++);
        for (; i > iStart; i--)
            a[i][j] = layer.get(k++);
        for (; j > jStart; j--)
            a[i][j] = layer.get(k++);
    }

    private static void extractMatrixLayer(int[][] a, List<Integer> layer, int iStart, int iEnd, int jStart, int jEnd) {
        int i = iStart;
        int j = jStart;
        for (; i < iEnd; i++)
            layer.add(a[i][j]);
        for (; j < jEnd; j++)
            layer.add(a[i][j]);
        for (; i > iStart; i--)
            layer.add(a[i][j]);
        for (; j > jStart; j--)
            layer.add(a[i][j]);
    }
}
