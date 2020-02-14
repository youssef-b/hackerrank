package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class implements an {@code Iterable} over all partitions of a given
 * list.
 *
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Feb 14, 2016 a.k.a. Friend Edition)
 * @param <T> The actual element type.
 */
public class PartitionIterable<T> implements Iterable<List<List<T>>> {

    private final List<T> allElements = new ArrayList<>();
    private final int blocks;

    public PartitionIterable(List<T> allElements, int blocks) {
        checkNumberOfBlocks(blocks, allElements.size());
        this.allElements.addAll(allElements);
        this.blocks = blocks;
    }

    @Override
    public Iterator<List<List<T>>> iterator() {
        return new PartitionIterator<>(allElements, blocks);
    }

    private void checkNumberOfBlocks(int blocks, int numberOfElements) {
        if (blocks < 1) {
            throw new IllegalArgumentException(
                    "The number of blocks should be at least 1, received: " +
                            blocks);
        }

        if (blocks > numberOfElements) {
            throw new IllegalArgumentException(
                    "The number of blocks should be at most " +
                            numberOfElements + ", received: " + blocks);
        }
    }

    private static final class PartitionIterator<T>
            implements Iterator<List<List<T>>> {

        private List<List<T>> nextPartition;
        private final List<T> allElements = new ArrayList<>();
        private final int blocks;

        private final int[] first;
        private final int[] second;
        private final int n;

        PartitionIterator(List<T> allElements, int blocks) {
            this.allElements.addAll(allElements);
            this.blocks = blocks;
            this.n = allElements.size();

            first = new int[n];
            second = new int[n];

            if (n != 0) {
                for (int i = 0; i < n - blocks + 1; ++i) {
                    first[i] = 0;
                    second[i] = 0;
                }

                for (int i = n - blocks + 1; i < n; ++i) {
                    first[i] = second[i] = i - n + blocks;
                }

                loadPartition();
            }
        }

        @Override
        public boolean hasNext() {
            return nextPartition != null;
        }

        @Override
        public List<List<T>> next() {
            if (nextPartition == null) {
                throw new NoSuchElementException("No more partitions left.");
            }

            List<List<T>> partition = nextPartition;
            generateNextPartition();
            return partition;
        }

        private void loadPartition() {
            nextPartition = new ArrayList<>(blocks);

            for (int i = 0; i < blocks; ++i) {
                nextPartition.add(new ArrayList<>());
            }

            for (int i = 0; i < n; ++i) {
                nextPartition.get(first[i]).add(allElements.get(i));
            }
        }

        private void generateNextPartition() {
            for (int i = n - 1; i > 0; --i) {
                if (first[i] < blocks - 1 && first[i] <= second[i - 1]) {
                    first[i]++;
                    second[i] = Math.max(second[i], first[i]);

                    for (int j = i + 1; j < n - blocks + second[i] + 1; ++j) {
                        first[j] = 0;
                        second[j] = second[i];
                    }

                    for (int j = n - blocks + second[i] + 1; j < n; ++j) {
                        first[j] = second[j] = blocks - n + j;
                    }

                    loadPartition();
                    return;
                }
            }

            nextPartition = null;
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        int row = 1;

        for (int blocks = 1; blocks <= list.size(); ++blocks) {
            for (List<List<String>> partition :
                    new PartitionIterable<>(list, blocks)) {
                System.out.printf("%2d: %s\n", row++, partition);
            }
        }
    }
}