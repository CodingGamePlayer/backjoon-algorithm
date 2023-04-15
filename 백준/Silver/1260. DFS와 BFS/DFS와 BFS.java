import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start);
        System.out.println();
        bfs(start);

    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Deque<Integer> deque = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        deque.add(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            System.out.print(node + " ");
            for (int next : graph[node]) {
                if (!visited[next]){
                    visited[next] = true;
                    deque.add(next);
                }
            }
        }
    }
}