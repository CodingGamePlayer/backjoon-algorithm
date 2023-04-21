import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n ; i++) {
            deque.add(i);
        }

        while (deque.size() != 1) {
            deque.poll();
            deque.offer(deque.poll());
        }

        System.out.println(deque.pop());
    }
}