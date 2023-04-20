import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 입력 받은 숫자 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 배열 정렬

        // 산술평균 구하기
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double mean = sum / n;

        // 중앙값 구하기
        int median = arr[n / 2];

        // 최빈값 구하기
        int[] count = new int[8001]; // 숫자의 개수를 저장할 배열
        int maxCount = 0;
        boolean isSecond = false; // 두 번째 최빈값인지 확인할 변수
        for (int i = 0; i < n; i++) {
            count[arr[i] + 4000]++;
            maxCount = Math.max(maxCount, count[arr[i] + 4000]);
        }
        int mode = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxCount) {
                if (isSecond) {
                    mode = i - 4000;
                    break;
                }
                mode = i - 4000;
                isSecond = true;
            }
        }

        // 범위 구하기
        int range = arr[n - 1] - arr[0];

        // 결과 출력
        System.out.println(Math.round(mean)); // 산술평균 (반올림)
        System.out.println(median); // 중앙값
        System.out.println(mode); // 최빈값
        System.out.println(range); // 범위
    }
}
