import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, r, c, result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        result = 0;
        int size = (int) Math.pow(2, N);

        find(0, 0, size);

    }

    private static void find(int x, int y, int size) {
        if (size == 1) {
            if (x == r && y == c) System.out.println(result);
            result++;
            return;
        }

        int nSize = size / 2;
        int num = nSize * nSize;
        if (r < nSize + x && c < nSize + y) {
            find(x, y, nSize);
        } else if (r < nSize + x && c >= nSize + y) {
            result += num;
            find(x, y + nSize, nSize);
        } else if (r >= nSize + x && c < nSize + y) {
            result += num * 2;
            find(x + nSize, y, nSize);
        } else {
            result += num * 3;
            find(x + nSize, y + nSize, nSize);
        }
    }
}