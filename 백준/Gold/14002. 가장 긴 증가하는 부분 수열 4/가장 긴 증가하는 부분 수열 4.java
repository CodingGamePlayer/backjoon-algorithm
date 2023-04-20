
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] before = new int[n];

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
            before[i] = -1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    before[i] = j;
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(max);
        Deque<Integer> deque = new LinkedList<>();
        while (maxIdx != -1) {
            deque.push(arr[maxIdx]);
            maxIdx = before[maxIdx];
        }

        while (!deque.isEmpty()){
            System.out.print(deque.pop() + " ");
        }
        System.out.println();
    }
}