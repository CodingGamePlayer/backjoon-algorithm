
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isMixed = false;
        int[] arr = new int[8];
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < 8; i++) {
            cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            if (i == 0) {
                pre = cur;
                continue;
            } else if (Math.abs(pre - cur) > 1) {
                isMixed = true;
            }
            pre = cur;
        }

        if (isMixed) {
            System.out.println("mixed");
        } else if (arr[0] == 8 && arr[7] == 1) {
            System.out.println("descending");
        } else {
            System.out.println("ascending");
        }
    }

}