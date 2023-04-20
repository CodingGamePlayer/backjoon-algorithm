import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] answer = new int[n];

        Deque<Integer> output = new LinkedList<>();
        Deque<Integer> input = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            answer[i] = sc.nextInt();
        }

        int point = 0;
        for (int i = 1; i <= n ; i++) {
            input.push(i);
            sb.append("+\n");
            while (!input.isEmpty() && input.peekFirst() == answer[point]) {
                output.push(input.pop());
                sb.append("-\n");
                point++;
            }
        }

        if (!input.isEmpty()) System.out.println("NO");
        else System.out.println(sb.toString());

    }

}
