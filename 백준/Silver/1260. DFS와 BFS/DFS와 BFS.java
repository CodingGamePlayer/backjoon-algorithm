
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> graph[];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        int s = sc.nextInt();

        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }
        
        visited = new boolean[n + 1];
        dfs(s);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(s);
        sb.append("\n");

        System.out.println(sb.toString());

    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.add(node);
        sb.append(node + " ");

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]){
                    visited[next] = true;
                    sb.append(next + " ");
                    queue.add(next);
                }
            }
        }

    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {

                dfs(next);
            }
        }
    }
}


