package src;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= a; i++) {
            deque.offer(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        int count = 1;
        while (!deque.isEmpty()) {
            if (count % b == 0) {
                answer.add(deque.poll());
            } else {
                deque.offer(deque.poll());
            }
            count++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < answer.size(); i++) {
            if (i == answer.size() - 1) {
                sb.append(answer.get(i) + ">");
            } else {
                sb.append(answer.get(i) + ", ");
            }
        }

        System.out.println(sb.toString());
    }

}




