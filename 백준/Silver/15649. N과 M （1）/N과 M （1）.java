
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n];

        dfs(n, m);
    }

    private static void dfs(int n, int m) {
        if (stack.size() == m) {
            for (int a : stack) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                stack.push(i + 1);
                dfs(n, m);
                stack.pop();
                visited[i] = false;
            }
        }
    }


}
