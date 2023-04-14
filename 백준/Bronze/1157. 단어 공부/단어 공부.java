import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase(); // 입력받은 문자열을 모두 대문자로 변환
        int[] cnt = new int[26]; // 알파벳 갯수를 저장할 배열

        // 문자열에서 알파벳의 갯수를 세어서 cnt 배열에 저장
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }

        int maxCnt = 0; // 가장 많이 사용된 알파벳의 갯수
        char maxChar = '?'; // 가장 많이 사용된 알파벳

        // cnt 배열에서 가장 큰 값을 찾아서, 가장 많이 사용된 알파벳을 구함
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                maxChar = (char) ('A' + i);
            } else if (cnt[i] == maxCnt) {
                maxChar = '?'; // 가장 많이 사용된 알파벳이 여러 개인 경우
            }
        }

        System.out.println(maxChar);
    }
}