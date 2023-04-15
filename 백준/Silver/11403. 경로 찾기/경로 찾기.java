import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 인접 행렬 입력 받기
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i);
            for (int j = 0; j < n; j++) {
                System.out.print(visited[j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    static void dfs(int curr) {
        for (int next = 0; next < n; next++) {
            if (graph[curr][next] == 1 && !visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
