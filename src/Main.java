package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        divide(0, 0, n);

        System.out.println(sb.toString());
    }

    public static void divide(int x, int y, int n) {
        int color = arr[x][y];
        boolean sameColor = true;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (color != arr[i][j]) {
                    sameColor = false;
                    break;
                }
            }
            if (!sameColor) break;
        }

        if (sameColor) {
            sb.append(color);
        } else {
            sb.append("(");
            int newSize = n / 2;
            divide(x, y, newSize);
            divide(x, y + newSize, newSize);
            divide(x + newSize, y, newSize);
            divide(x + newSize, y + newSize, newSize);
            sb.append(")");
        }
    }
}

