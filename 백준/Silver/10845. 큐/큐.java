import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        Deque<String> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String func = sc.next();

            if ("push".equals(func)) {
                queue.push(sc.next());
                continue;
            }
            else if ("pop".equals(func)) {
                if (queue.isEmpty()) sb.append(-1);
                else sb.append(queue.pollLast());
            }
            else if ("size".equals(func)) sb.append(queue.size());
            else if ("empty".equals(func)) {
                if (queue.isEmpty()) sb.append(1);
                else sb.append(0);
            }
            else if ("front".equals(func)) {
                if (queue.isEmpty()) sb.append(-1);
                else sb.append(queue.peekLast());
            }
            else {
                if (queue.isEmpty()) sb.append(-1);
                else sb.append(queue.peekFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}