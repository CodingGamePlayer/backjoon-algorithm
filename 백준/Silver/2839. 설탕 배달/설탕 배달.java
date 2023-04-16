import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 0;
        if (n > 1) dp[1] = Integer.MAX_VALUE;
        if (n > 2) dp[2] = Integer.MAX_VALUE;

        for (int i = 3; i <= n ; i++) {
            dp[i] = Integer.MAX_VALUE;

            if (i >= 3 && dp[i - 3] != Integer.MAX_VALUE) {
                dp[i] = dp[i - 3] + 1;
            }
            if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i -5] + 1);
            }
        }

        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}

