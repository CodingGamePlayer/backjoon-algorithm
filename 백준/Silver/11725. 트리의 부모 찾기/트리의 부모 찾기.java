import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        parent = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs() {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        visited[1] = true;
        q.offer(1);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int child : tree[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    parent[child] = node;
                    q.offer(child);
                }
            }
        }
    }
}