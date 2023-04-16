import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.next();

            if ("0".equals(input)) break;

            boolean isPalindrome = true;
            int len = input.length();

            for (int i = 0; i < len / 2; i++) {
                if (input.charAt(i) != input.charAt(len - i - 1)){
                    isPalindrome = false;
                    break;
                }
            }

            System.out.println(isPalindrome ? "yes" : "no");
        }
    }
}