package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3]; // RGB 색상 비용을 저장할 배열

        // 입력받은 색상 비용 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 다이나믹 프로그래밍으로 최소 비용 계산
        int[][] dp = new int[n][3]; // 각 집을 해당 색으로 칠할 때까지의 최소 비용을 저장할 배열
        dp[0][0] = cost[0][0]; // 첫 번째 집을 빨간색으로 칠할 때 최소 비용
        dp[0][1] = cost[0][1]; // 첫 번째 집을 초록색으로 칠할 때 최소 비용
        dp[0][2] = cost[0][2]; // 첫 번째 집을 파란색으로 칠할 때 최소 비용

        for (int i = 1; i < n; i++) {
            // i번째 집을 빨간색으로 칠할 때의 최소 비용 계산
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            // i번째 집을 초록색으로 칠할 때의 최소 비용 계산
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            // i번째 집을 파란색으로 칠할 때의 최소 비용 계산
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        // n번째 집까지 칠하는데 드는 최소 비용 출력
        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}




