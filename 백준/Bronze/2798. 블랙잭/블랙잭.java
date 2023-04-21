import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Math.abs(o1 - m) - Math.abs(o2 - m));
        dfs(pq, 0, 0);

        System.out.println(pq.peek());
    }

    private static void dfs(PriorityQueue<Integer> pq, int depth, int num) {
        if (depth == 3) {
            if (num <= m) pq.add(num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(pq, depth + 1, num + arr[i]);
                visited[i] = false;
            }
        }
    }
}