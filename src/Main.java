package src;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void cut(int x, int y, int size) {
        int color = matrix[x][y]; // 시작점의 색상
        boolean sameColor = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (matrix[i][j] != color) { // 색상이 다르면 분할
                    sameColor = false;
                    break;
                }
            }
            if (!sameColor) {
                break;
            }
        }
        if (sameColor) { // 같은 색상이면 종이 개수 증가
            if (color == 0) {
                white++;
            } else {
                blue++;
            }
        } else { // 다른 색상이면 분할
            int newSize = size / 2;
            cut(x, y, newSize);
            cut(x, y + newSize, newSize);
            cut(x + newSize, y, newSize);
            cut(x + newSize, y + newSize, newSize);
        }
    }
}

