import java.util.*;

/**
 * https://www.hackerrank.com/challenges/similarpair
 */
public class SimilarPair2 {

    static class BinaryIndexedTree {

        public static void update(int binaryIndexedTree[], int val, int index) {
            index = index + 1;
            while (index < binaryIndexedTree.length) {
                binaryIndexedTree[index] += val;
                index = index + (index & -index);
            }
        }

        public static int getSum(int binaryIndexedTree[], int index) {
            index = index + 1;
            int sum = 0;
            while (index > 0) {
                sum += binaryIndexedTree[index];
                index = index - (index & -index);
            }
            return sum;
        }

        public static int getRangeSum(int binaryIndexedTree[], int start, int end) {

                return getSum(binaryIndexedTree, end) - getSum(binaryIndexedTree, start - 1);

        }


        public static int[] createBinaryIndexedTree(int inputArray[]) {
            int binaryIndexedTree[] = new int[inputArray.length + 1];
            for (int i = 0; i < inputArray.length; i++) {
                update(binaryIndexedTree, inputArray[i], i);
            }
            return binaryIndexedTree;
        }


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        Map<Integer, List<Integer>> tree = new HashMap<>(n);
        int root = -1;

        for (int i = 0; i < n - 1; i++) {
            int pData = sc.nextInt();
            int cData = sc.nextInt();
            if (i == 0)
                root = pData;

            List<Integer> children = tree.get(pData);
            if (children == null) {
                children = new LinkedList<>();
            }
            children.add(cData);
            tree.put(pData, children);

        }
        sc.close();

        int bit[]  = new int[n+2];
        long similar = dfs(tree, root, bit,n, k);

        System.out.println(similar);
    }

    private static long dfs(Map<Integer, List<Integer>> tree, int node, int bit[], int n, int k) {
        long similar = BinaryIndexedTree.getRangeSum(bit, Math.max(node - k, 1), Math.min(node + k, n));
        BinaryIndexedTree.update(bit, 1, node);
        List<Integer> children = tree.get(node);
        if (children != null) {
            for (Integer child : children) {
                similar += dfs(tree, child, bit,n, k);

            }
        }
        BinaryIndexedTree.update(bit, -1, node);

        return similar;
    }
}