import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();

        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int a : arr) {
                sum += Math.max(a - mid, 0);
            }

            if (sum >= M) {
                left = mid + 1;
                result = mid;
            } else  {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}