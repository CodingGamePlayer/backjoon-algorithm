import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());

            int[] dp = new int[t + 1];

            dp[1] = 1;
            if (t > 1) dp[2] = 2;
            if (t > 2) dp[3] = 4;

            for (int j = 4; j < t + 1; j++) {
                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }

            System.out.println(dp[t]);
        }

    }
}