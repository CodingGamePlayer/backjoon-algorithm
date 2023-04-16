import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;
        for (int i = 666; n != 0; i++) {
            String str = i + "";
            if (str.contains("666")) n--;
            answer = i;
        }

        System.out.println(answer);
    }
}