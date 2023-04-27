import java.util.Scanner;

public class Main {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 이동하려는 채널
        int M = sc.nextInt(); // 고장난 버튼의 개수

        for (int i = 0; i < M; i++) {
            int brokenNum = sc.nextInt();
            broken[brokenNum] = true; // 고장난 버튼 배열에 true 값으로 저장
        }

        int ans = Math.abs(N - 100); // 초기값은 +,- 버튼으로만 이동하는 경우

        // 0부터 500000까지의 범위에서 가능한 채널 찾기
        for (int i = 0; i <= 1000000; i++) {
            int channel = i;
            int len = possible(channel); // 가능한 채널의 길이를 구함
            if (len > 0) {
                int press = Math.abs(channel - N); // 채널에서 목표 채널로 가기 위해 눌러야 하는 버튼의 수를 구함
                ans = Math.min(ans, len + press); // 더 적은 버튼을 누르는 경우로 갱신
            }
        }
        System.out.println(ans);
    }

    static int possible(int channel) {
        if (channel == 0) {
            if (broken[0]) return 0;
            else return 1;
        }
        int len = 0;
        while (channel > 0) {
            if (broken[channel % 10]) return 0;
            len += 1;
            channel /= 10;
        }
        return len;
    }
}
