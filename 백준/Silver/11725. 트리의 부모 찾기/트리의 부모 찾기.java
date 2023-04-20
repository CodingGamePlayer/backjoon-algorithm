import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<Integer>[] graph;
    static int[] parents;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        bfs(1);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parents[i]);
        }

    }

    private static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(root);
        visited[root] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]){
                if (!visited[next]){
                    visited[next] = true;
                    parents[next] = cur;
                    queue.add(next);
                }
            }
        }
    }
}
