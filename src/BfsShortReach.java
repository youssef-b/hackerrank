import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach
 */
public class BfsShortReach {

    static class Node {
        int data;
        boolean visited = false;
        List<Node> adjacentNodes = new LinkedList<>();

        Node(int data) {
            this.data = data;
        }

        public void addAdjacentNode(Node child) {
            adjacentNodes.add(child);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        for (int i = 0; i < queries; i++) {
            int n = in.nextInt();
            int m = in.nextInt();

            Map<Integer, Node> nodesMap = new HashMap<>(n);
            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                Node uNode = getExistingOrNewNode(nodesMap, u);

                Node vNode = getExistingOrNewNode(nodesMap, v);

                uNode.addAdjacentNode(vNode);
                vNode.addAdjacentNode(uNode);
                nodesMap.put(u, uNode);
                nodesMap.put(v, vNode);
            }
            int s = in.nextInt();
            Node sNode = getExistingOrNewNode(nodesMap, s);
            bFS(sNode, n);

        }
    }

    //  BFS traversal
    static void bFS(Node sNode, int n) {

        // Create a queue
        LinkedList<Node> queue = new LinkedList<>();
        Node currentNode;
        int[] distances = new int[n];

        // Mark the current node as visited and enqueue it
        sNode.visited = true;
        queue.add(sNode);

        while (queue.size() != 0) {
            // Dequeue from queue
            currentNode = queue.poll();
            for (Node node : currentNode.adjacentNodes) {
                if (!node.visited) {
                    node.visited = true;
                    queue.add(node);
                    distances[node.data - 1] = distances[currentNode.data - 1] + 6;

                }
            }
        }
        String result = IntStream.range(0, n)
                .filter(i -> i != sNode.data - 1)
                .map(i -> distances[i])
                .map(i -> (i > 0 ? i : -1))
                .mapToObj(i -> "" + i)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }

    private static Node getExistingOrNewNode(Map<Integer, Node> nodesMap, int u) {
        Node uNode = nodesMap.get(u);
        uNode = (uNode == null) ? new Node(u) : uNode;
        return uNode;
    }
}