import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        boolean[] brokenNum = new boolean[10];

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                brokenNum[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);

        for (int i = 0; i <= 1000000; i++) {
            int channel = i;
            int len = isPossible(channel, brokenNum); // 가능한 채널의 길이를 구함
            if (len > 0) {
                int press = Math.abs(channel - N); // 채널에서 목표 채널로 가기 위해 눌러야 하는 버튼의 수를 구함
                ans = Math.min(ans, len + press); // 더 적은 버튼을 누르는 경우로 갱신
            }
        }

        System.out.println(ans);

    }

    private static int isPossible(int num, boolean[] brokenNum) {
        if (num == 0) {
            if (brokenNum[0]) return 0;
            else return 1;
        }
        int len = 0;
        while (num > 0) {
            if (brokenNum[num % 10]) return 0;
            len += 1;
            num /= 10;
        }
        return len;
    }

}