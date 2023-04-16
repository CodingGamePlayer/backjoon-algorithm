import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        long max = 0;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            arr[i] = cur;
            max = Math.max(max, cur);
        }

        long left = 1;
        long right = max;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= t) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
