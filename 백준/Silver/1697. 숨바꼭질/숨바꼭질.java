
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100_001];

        Queue<Integer> queue = new LinkedList<>();
        visited[N] = 1;

        queue.add(N);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == K) {
                System.out.println(visited[x] - 1);
                break;
            }

            if (x - 1 >= 0 && visited[x - 1] == 0) {
                queue.offer(x - 1);
                visited[x - 1] = visited[x] + 1;
            }
            if (x + 1 <= 100_000 && visited[x + 1] == 0) {
                queue.offer(x + 1);
                visited[x + 1] = visited[x] + 1;
            }
            if (x * 2 <= 100_000 && visited[x * 2] == 0) {
                queue.offer(x * 2);
                visited[x * 2] = visited[x] + 1;
            }
        }


    }

}