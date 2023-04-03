package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp(arr, n, 0, 0);
        System.out.println(answer);

    }

    private static void dp(int[][] arr, int n, int row, int col) {
        if (row >= n || col >= n) {
            return;
        }

        if (arr[row][col] == 0) {
            answer++;
            return;
        }

        dp(arr, n, row + arr[row][col], col);
        dp(arr, n , row, col + arr[row][col]);

    }


}
