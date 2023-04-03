package src;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int len = s.length();
        int answer = len;

        for (int i = 0; i < len; i++) {
            if (!solution(s.substring(i))){
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);;

    }

    static boolean solution(String s) {
        int left = 0;
        int right = s.length() -1;

        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
