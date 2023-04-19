
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 동전의 종류 수
        int k = sc.nextInt(); // 목표 금액
        int[] coins = new int[n]; // 동전의 가치
        int[] dp = new int[k + 1]; // 해당 금액을 만들 수 있는 경우의 수
        dp[0] = 1; // 0원은 항상 만들 수 있음

        // 동전 가치 입력 받기
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // 동전 가치별로 경우의 수 계산하기
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[k]);
    }
}


