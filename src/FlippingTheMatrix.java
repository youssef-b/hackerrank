import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-the-matrix
 */

public class FlippingTheMatrix {

    public static int max(int a, int b){
        return (a>b?a:b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int query = 0; query <q ; query++) {
            int n = in.nextInt();
            int[][] matrice = new int[2*n][2*n];
            for (int row=0;row<2*n;row++){
                for(int column=0;column<2*n;column++){
                    matrice[row][column]=in.nextInt();
                }
            }
            int sum=0;
            for (int row=0;row<n;row++){
                for(int column=0;column<n;column++){
                    int elem1 = matrice[row][column];
                    int elem2 = matrice[2*n-1-row][column];
                    int elem3 = matrice[row][2*n-1-column];
                    int elem4 = matrice[2*n-1-row][2*n-1-column];
                    sum += max(max(elem1,elem2),max(elem3,elem4));
                }
            }
            System.out.println(sum);

        }
    }
}