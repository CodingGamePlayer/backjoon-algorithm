
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Node[] graph;

    static class Node {
        char node;
        Node left;
        Node right;

        public Node(char node) {
            this.node = node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new Node[26];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            char node = s[0].charAt(0);
            char left = s[1].charAt(0);
            char right = s[2].charAt(0);

            int nodeIdx = node - 'A';
            if (graph[nodeIdx] == null) graph[nodeIdx] = new Node(node);

            int leftIdx = left - 'A';
            if ('.' != left) {
                if (graph[leftIdx] == null) {
                    graph[leftIdx] = new Node(left);
                }
                graph[nodeIdx].left = graph[leftIdx];
            }

            int rightIdx = right - 'A';
            if ('.' != right) {
                if (graph[rightIdx] == null) {
                    graph[rightIdx] = new Node(right);
                }
                graph[nodeIdx].right = graph[rightIdx];
            }
        }

        preOrder(graph[0]);
        System.out.println();

        inOrder(graph[0]);
        System.out.println();

        postOrder(graph[0]);
        System.out.println();

    }

    private static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.node);

    }

    private static void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.node);
        inOrder(node.right);
    }

    private static void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node.node);
        preOrder(node.left);
        preOrder(node.right);
    }


}
