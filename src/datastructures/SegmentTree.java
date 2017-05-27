package datastructures;

public class SegmentTree {

    private int[] segmentTree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        segmentTree = new int[2 * n];

        for (int i = 0; i < n; i++) {
            segmentTree[n + i] = arr[i];
        }
        for (int i = n - 1; i > 0; i--) {
            segmentTree[i] = Math.min(segmentTree[2 * i], segmentTree[2 * i + 1]);
        }
    }

    public void update(int i, int value) {
        i += n;
        segmentTree[i] = value;

        while (i > 1) {
            i = i / 2;
            segmentTree[i] = Math.min(segmentTree[2 * i], segmentTree[2 * i + 1]);
        }
    }

    public int minimum(int low, int high) {
        low += n;
        high += n;
        int min = Integer.MAX_VALUE;

        while (low < high) {
            if (low % 2 == 1) {
                min = Math.min(min, segmentTree[low]);
                low++;
            }
            if (high % 2 == 1) {
                high--;
                min = Math.min(min, segmentTree[high]);
            }
            low = low / 2;
            high = high / 2;
        }

        return min;
    }
}