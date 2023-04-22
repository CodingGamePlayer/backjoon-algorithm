
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] cols;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cols = new int[n];
        backtracking(0);
        System.out.println(count);
    }

    static void backtracking(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            cols[row] = i;
            if (isPossible(row)){
                backtracking(row + 1);
            }
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == cols[row] || Math.abs(cols[row] - cols[i]) == row - i) return false;
        }
        return true;
    }
}




