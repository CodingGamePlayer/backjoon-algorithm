
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;

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

        System.out.println(recur(0, 0, N));

    }

    public static int recur(int i, int j, int size) {
        int[] arr = new int[4];

        if (size == 2) {

            int idx = 0;
            for (int a = i; a < i + 2; a++) {
                for (int b = j; b < j + 2; b++) {
                    arr[idx++] = matrix[a][b];
                }
            }

            Arrays.sort(arr);
            return arr[2];
        }
        size /= 2;
        arr[0] = recur(i, j, size);
        arr[1] = recur(i, j + size, size);
        arr[2] = recur(i + size, j, size);
        arr[3] = recur(i + size, j + size, size);

        Arrays.sort(arr);
        return arr[2];
    }
}
