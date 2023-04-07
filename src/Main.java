package src;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int num = sc.nextInt();
            System.out.println(solution(num));
        }

    }

    private static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        if (n >= 2) {
            dp[2] = 2;
        }
        if (n >= 3) {
            dp[3] = 4;
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}

