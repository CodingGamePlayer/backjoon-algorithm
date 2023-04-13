package src;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();

            int[] dp0 = new int[target + 1];
            int[] dp1 = new int[target + 1];

            dp0[0] = 1;
            if (target >= 1) dp1[1] = 1;

            for (int j = 2; j <= target; j++) {
                dp0[j] = dp0[j - 1] + dp0[j - 2];
                dp1[j] = dp1[j - 1] + dp1[j - 2];
            }
            System.out.println(dp0[target] + " " + dp1[target]);
        }
    }

}



