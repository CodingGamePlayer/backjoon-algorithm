package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> deque = new LinkedList<>();

        while (!"=".equals(deque.peekLast())) {
            deque.offerLast(sc.nextLine());
        }

        solution(deque);
    }

    private static void solution(Deque<String> deque) {
        int result = 0;
        String operation = "";
        boolean isOperation = false;
        result = Integer.parseInt(deque.pollFirst());
        while (!deque.isEmpty()) {
            String s = deque.pollFirst();

            if ("+".equals(s) || "-".equals(s) || "/".equals(s) || "*".equals(s)) {
                isOperation = true;
                operation = s;
            } else if ("=".equals(s)) {
                break;
            } else {
                switch (operation) {
                    case "+":
                        result += Integer.parseInt(s);
                        break;
                    case "-":
                        result -= Integer.parseInt(s);
                        break;
                    case "/":
                        result /= Integer.parseInt(s);
                        break;
                    case "*":
                        result *= Integer.parseInt(s);
                        break;
                    default:
                        isOperation = false;
                }
            }


        }

        System.out.println(result);
    }
}

