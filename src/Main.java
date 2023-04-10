package src;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        solution(arr, n);

    }

    private static void solution(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        System.out.println(Arrays.stream(dp).reduce(0, (o1, o2) -> o1 + o2));
    }
}




