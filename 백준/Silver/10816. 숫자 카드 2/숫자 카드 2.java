import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            stack.push(scan.nextInt());
        }

        int m = scan.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int num = scan.nextInt();
            queue.push(num);
            map.put(num, 0);
        }

        for (int i = 0; i < n; i++) {
            Integer pop = stack.pop();
            map.put(pop, map.getOrDefault(pop, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            Integer pop = queue.pollLast();
            sb.append(map.get(pop) + " ");
        }
        System.out.println(sb.toString());
    }
}