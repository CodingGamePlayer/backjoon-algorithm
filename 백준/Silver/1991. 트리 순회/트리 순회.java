
import java.io.*;

public class Main {

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] tree = new Node[26];

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split(" ");
            char node = strArr[0].charAt(0);
            char left = strArr[1].charAt(0);
            char right = strArr[2].charAt(0);

            int cur = node - 'A';
            if (tree[cur] == null) {
                tree[cur] = new Node(node);
            }

            int leftNode = left - 'A';
            if (left != '.') {
                if (tree[leftNode] == null) tree[leftNode] = new Node(left);
                tree[cur].left = tree[leftNode];
            }

            int rightNode = right - 'A';
            if (right != '.') {
                if (tree[rightNode] == null) tree[rightNode] = new Node(right);
                tree[cur].right = tree[rightNode];
            }
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    private static void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
}