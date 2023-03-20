package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int[] bcnt = new int[20]; // 각 자리수별로 1이 몇 개 있는지

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < n; j++) {
                if ((v[j] & (1 << i)) != 0) {
                    bcnt[i]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < 20; i++) {
            ans += (1L << i) * bcnt[i] * (n - bcnt[i]);
        }

        System.out.println(ans);
    }
}

