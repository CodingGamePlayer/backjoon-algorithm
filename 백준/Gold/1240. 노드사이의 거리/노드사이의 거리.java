import java.io.*;
import java.util.*;

public class Main {
    static int n, t;
    static List<Node>[] tree;

    private static class Node {
        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        t = Integer.parseInt(s[1]);

        tree = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] arr = br.readLine().split(" ");

            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            int weight = Integer.parseInt(arr[2]);

            tree[u].add(new Node(v, weight));
            tree[v].add(new Node(u, weight));
        }

        for (int i = 0; i < t; i++) {
            String[] arr = br.readLine().split(" ");

            int result = dfs(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int start, int end) {
        boolean[] visited = new boolean[n + 1];
        int[] sumWeight = new int[n + 1];

        Deque<Integer> deque = new LinkedList<>();

        visited[start] = true;
        deque.add(start);

        while (!deque.isEmpty()) {
            int cur = deque.poll();

            for (Node next : tree[cur]) {
                int nextNode = next.node;
                int weight = next.weight;

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    sumWeight[nextNode] = sumWeight[cur] + weight;
                    deque.offer(nextNode);
                }
            }
        }

        return sumWeight[end];
    }

}
