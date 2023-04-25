
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[10_001];

        for (int i = 0; i < n; i++) {
            nums[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            for (int j = 0; j < nums[i]; j++) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}