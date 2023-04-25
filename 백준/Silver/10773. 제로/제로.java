import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if (cur != 0) {
                stack.push(cur);
            } else {
                stack.pop();
            }
        }

        System.out.println(Arrays.stream(stack.stream().mapToInt(i -> i).toArray()).sum());
    }
}