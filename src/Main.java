package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }
        dac(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void dac(int x, int y, int size) {
        int num = arr[x][y];
        boolean sameNum = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != arr[i][j]) {
                    sameNum = false;
                    break;
                }
            }
            if (!sameNum) break;
        }

        if (sameNum) {
            if (num == -1) minus++;
            else if (num == 0) zero++;
            else plus++;
        } else {
            int n = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dac(x + i * n, y + j * n, n);
                }
            }
        }
    }
}

