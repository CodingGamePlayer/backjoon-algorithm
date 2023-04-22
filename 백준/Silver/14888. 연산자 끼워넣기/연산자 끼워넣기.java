
import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static int[] op = new int[4];

    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < op.length; i++) {
            op[i] = sc.nextInt();
        }

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int depth) {
        if (depth == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 0) dfs(num + arr[depth], depth + 1);
                else if (i == 1) dfs(num - arr[depth], depth + 1);
                else if (i == 2) dfs(num * arr[depth], depth + 1);
                else dfs(num / arr[depth], depth + 1);
                op[i]++;
            }
        }

    }
}
