package contest;

import java.util.*;

/**
 * https://www.hackerrank.com/contests/w37/challenges/two-efficient-teams/problem
 */
public class TwoEfficientTeams2 {


    //https://en.wikipedia.org/wiki/Stirling_numbers_of_the_second_kind

    static class PartitionIterable<T> implements Iterable<List<List<T>>> {

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

            private final int[] s;
            private final int[] m;
            private final int n;

            PartitionIterator(List<T> allElements, int blocks) {
                this.allElements.addAll(allElements);
                this.blocks = blocks;
                this.n = allElements.size();

                s = new int[n];
                m = new int[n];

                if (n != 0) {
                    for (int i = 0; i < n - blocks + 1; ++i) {
                        s[i] = 0;
                        m[i] = 0;
                    }

                    for (int i = n - blocks + 1; i < n; ++i) {
                        s[i] = m[i] = i - n + blocks;
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
                    nextPartition.get(s[i]).add(allElements.get(i));
                }
            }

            private void generateNextPartition() {
                for (int i = n - 1; i > 0; --i) {
                    if (s[i] < blocks - 1 && s[i] <= m[i - 1]) {
                        s[i]++;
                        m[i] = Math.max(m[i], s[i]);

                        for (int j = i + 1; j < n - blocks + m[i] + 1; ++j) {
                            s[j] = 0;
                            m[j] = m[i];
                        }

                        for (int j = n - blocks + m[i] + 1; j < n; ++j) {
                            s[j] = m[j] = blocks - n + j;
                        }

                        loadPartition();
                        return;
                    }
                }

                nextPartition = null;
            }
        }

    }

    // Complete the maximumEfficiency function below.
    public static final String SEP = ":";
    private static final Scanner scanner = new Scanner(System.in);

    static class Group {
        long efficiency;
        public List<String> members = new ArrayList<>();

        public Group(long efficiency) {
            this.efficiency = efficiency;
        }

    }

    static long maximumEfficiency(int n, int m) {

        List<Group> groups = new ArrayList<>();
        List<String> employees = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            int membersCount = scanner.nextInt();
            long efficiency = scanner.nextLong();
            Group group = new Group(efficiency);
            for (int j = 0; j < membersCount; j++) {
                int member = scanner.nextInt();
                group.members.add("" + member);
            }
            groups.add(group);

        }
        for (int i = 1; i <= n; i++) {
            employees.add("" + i);
        }

        long maxEfficiency = 0;

        for (List<List<String>> partition :
                new PartitionIterable<>(employees, 2)) {
            List<String> team1 = partition.get(0);
            List<String> team2 = partition.get(1);
            long efficiency = 0;
            for (Group group : groups) {
                if (team1.containsAll(group.members)) {
                    efficiency += group.efficiency;
                } else if (team2.containsAll(group.members)) {
                    efficiency += group.efficiency;
                }
            }
            maxEfficiency = Math.max(maxEfficiency, efficiency);
        }

        return maxEfficiency;

    }

    public static void main(String[] args) {


        int n = scanner.nextInt();

        int m = scanner.nextInt();

        long result = maximumEfficiency(n, m);

        System.out.println(result);


        scanner.close();
    }
}
