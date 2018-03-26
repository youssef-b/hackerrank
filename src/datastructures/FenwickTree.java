package datastructures;

/**
 * Created by youssef.
 */
public class FenwickTree {


    public static void update(int fenwickTree[], int val, int index) {
        while (index < fenwickTree.length) {
            fenwickTree[index] += val;
            index |= index + 1;
        }
    }

    public static int getSum(int fenwickTree[], int index) {
        int sum = 0;
        while (index >= 0) {
            sum += fenwickTree[index];
            index = (index & (index + 1)) - 1;
        }
        return sum;
    }

    public static int getRangeSum(int fenwickTree[], int start, int end) {

        return getSum(fenwickTree, end) - getSum(fenwickTree, start - 1);

    }


    public static int[] createFenwickTree(int inputArray[]) {
        int fenwickTree[] = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            update(fenwickTree, inputArray[i], i);
        }
        return fenwickTree;
    }

    public static void main(String args[]){
        int input[] = {5,2,-6,4,15,-1};
        int fenwickTree[] = createFenwickTree(input);
        assert 5 == getSum(fenwickTree, 0);
        assert 7 == getSum(fenwickTree, 1);
        assert 1 == getSum(fenwickTree, 2);
        assert 5 == getSum(fenwickTree, 3);
        assert 20 == getSum(fenwickTree, 4);
        assert 19 == getSum(fenwickTree, 5);
    }
}
