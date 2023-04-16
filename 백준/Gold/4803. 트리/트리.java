import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            adjList = new ArrayList[N+1];
            visited = new boolean[N+1];
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adjList[u].add(v);
                adjList[v].add(u);
            }

            int trees = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    if (dfs(i, 0)) {
                        continue;
                    }
                    trees++;
                }
            }

            tc++;
            if (trees == 0) {
                sb.append("Case " + tc + ": No trees.\n");
            } else if (trees == 1) {
                sb.append("Case " + tc + ": There is one tree.\n");
            } else {
                sb.append("Case " + tc + ": A forest of " + trees + " trees.\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static boolean dfs(int node, int parent) {
        visited[node] = true;
        for (int next : adjList[node]) {
            if (next == parent) continue;
            if (visited[next]) {
                return true;
            }
            if (dfs(next, node)) {
                return true;
            }
        }
        return false;
    }
}
