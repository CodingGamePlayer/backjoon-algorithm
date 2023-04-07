package src;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;

            if (i - 3 >= 0 && dp[i - 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }

            if (i - 5 >= 0 && dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}

