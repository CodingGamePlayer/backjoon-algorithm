
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(arr, n));
    }

    private static int bfs(int[][] arr, int n) {
        int[][] dp = new int[n][n];

        dp[0] = arr[0].clone();

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                int left = arr[i][j] + dp[i - 1][Math.max(0, j - 1)];
                int right = arr[i][j] + dp[i - 1][j];
                dp[i][j] = Math.max(left, right);
            }
        }

        return Arrays.stream(dp[n - 1]).max().orElse(0);
    }


}
