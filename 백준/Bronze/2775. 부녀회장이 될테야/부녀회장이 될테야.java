import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int dong = sc.nextInt();
            int ho = sc.nextInt();
            System.out.println(solution(dong, ho));
        }

    }

    private static int solution(int dong, int ho) {
        int[][] dp = new int[dong + 1][ho + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[i + 1][j] += dp[i][k];
                }
            }
        }

        return dp[dong][ho];
    }
}
