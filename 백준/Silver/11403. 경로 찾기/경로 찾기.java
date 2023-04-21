import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];

            bfs(i);

            for (int j = 0; j < n; j++) {
                System.out.print(visited[j] ? 1 + " " : 0 + " ");
            }
            System.out.println();
        }


    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (int i = 0; i < graph[cur].length; i++) {
                if (graph[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
