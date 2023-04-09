package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        dfs(n, m, 0, 0);
    }

    private static void dfs(int n, int m, int depth, int i) {
        if (depth == m) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            return;
        }

        for (int j = i; j < n; j++) {
            if (!visited[j]) {
                visited[j] = true;
                arr[i] = j + 1;
                dfs(n, m, depth + 1, j + 1);
                visited[j] = false;
            }
        }
    }

}




