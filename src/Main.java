package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int solution = solution(arr, target);
        System.out.println(solution);
    }

    private static int solution(int[] arr, int target) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (true) {
            if (sum >= target) {
                sum -= arr[left++];
            } else if (right == arr.length) {
                break;
            } else {
                sum += arr[right++];
            }

            if (sum == target) {
                answer++;
            }
        }

        return answer;
    }

}
