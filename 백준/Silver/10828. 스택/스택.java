import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();

            switch (cmd) {
                case "push":
                    int num = sc.nextInt();
                    stack.push(num);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.pop() + "\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size() + "\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.peek() + "\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
