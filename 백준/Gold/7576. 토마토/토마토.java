
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = bfs();
        System.out.println(days);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        int day = 0;
        while (!queue.isEmpty()) {
            int[] curArr = queue.poll();
            int curX = curArr[0];
            int curY = curArr[1];
            int curD = curArr[2];

            day = curD;

            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                    if (map[nX][nY] == 0 && !visited[nX][nY]) {
                        queue.add(new int[]{nX, nY, curD + 1});
                        visited[nX][nY] = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return day;
    }
}
