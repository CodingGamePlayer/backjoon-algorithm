import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int target = sc.nextInt();

            Queue<int[]> deque = new LinkedList<>();
            int[] priority = new int[len];
            for (int j = 0; j < len; j++) {
                int p = sc.nextInt();

                deque.offer(new int[]{j, p});
                priority[j] = p;
            }

            Arrays.sort(priority);
            int idx = priority.length - 1;
            int cnt = 1;
            while (true) {
                if (deque.peek()[1] == priority[idx]) {
                    if (deque.peek()[0] == target) {
                        System.out.println(cnt);
                        break;
                    } else {
                        deque.poll();
                        cnt++;
                    }
                    idx--;
                } else {
                    deque.offer(deque.poll());
                }
            }

        }
    }
}
