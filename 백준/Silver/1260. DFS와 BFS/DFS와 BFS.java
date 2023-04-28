
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            Collections.sort(graph[u]);
            graph[v].add(u);
            Collections.sort(graph[v]);
        }

        dfs(V, bw);
        bw.flush();
        System.out.println();
        bfs(V, bw);
        bw.flush();
    }

    private static void bfs(int node, BufferedWriter bw) throws IOException {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            bw.write(poll + " ");
            for (int next : graph[poll]) {
                if (!visited[next] && !queue.contains(next)) {
                    queue.add(next);
                }
            }

        }

    }

    private static void dfs(int node, BufferedWriter bw) throws IOException {
        bw.write(node + " ");
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, bw);
            }
        }
    }

}