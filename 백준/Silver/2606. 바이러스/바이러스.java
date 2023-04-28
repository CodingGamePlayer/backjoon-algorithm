import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

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
            graph[v].add(u);
        }

        System.out.println(bfs(1));
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            for (int next : graph[poll]) {
                if (!visited[next] && !queue.contains(next)) {
                    queue.add(next);
                    cnt++;
                }
            }

        }
        return cnt;

    }

}