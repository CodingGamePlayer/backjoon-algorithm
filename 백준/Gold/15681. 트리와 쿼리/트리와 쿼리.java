import java.io.*;
import java.util.*;

public class Main {
    static int r, n, q;
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] subTree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);

        tree = new ArrayList[n + 1];
        subTree = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] nodes = br.readLine().split(" ");
            int u = Integer.parseInt(nodes[0]);
            int v = Integer.parseInt(nodes[1]);

            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(r);

        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());

            bw.write(subTree[query] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    private static void dfs(int node) {
        visited[node] = true;
        subTree[node] = 1;

        for (int next : tree[node]) {
            if (!visited[next]) {
                dfs(next);
                subTree[node] += subTree[next];
            }
        }

    }
}
