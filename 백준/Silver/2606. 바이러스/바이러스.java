import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean visited[];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int v = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            graph[from].add(to);
            graph[to].add(from);
        }

        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }
}