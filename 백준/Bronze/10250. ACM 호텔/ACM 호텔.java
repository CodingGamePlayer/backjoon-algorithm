import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int floor = n % h; // 층 수
            int room = (n / h) + 1; // 방 번호

            if (floor == 0) { // 꼭대기 층인 경우
                floor = h;
                room -= 1;
            }

            System.out.println(floor * 100 + room); // 방 번호 출력
        }
    }
}