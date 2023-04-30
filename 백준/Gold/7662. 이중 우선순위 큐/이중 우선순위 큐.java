import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> queue = new TreeMap<>();

            int Q = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < Q; j++) {
                String[] split = sc.nextLine().split(" ");
                String op = split[0];
                int num = Integer.parseInt(split[1]);

                if ("I".equals(op)) {
                    queue.put(num, queue.getOrDefault(num, 0) + 1);
                } else {
                    if (queue.isEmpty()) continue;

                    int target = num == 1 ? queue.lastKey() : queue.firstKey();
                    if (queue.put(target, queue.get(target) - 1) == 1) {
                        queue.remove(target);
                    }
                }
            }
            System.out.println(queue.size() == 0 ? "EMPTY" : queue.lastKey() + " " + queue.firstKey());
        }

    }
}