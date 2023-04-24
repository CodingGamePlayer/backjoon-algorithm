import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 올라가는 높이
        int b = sc.nextInt(); // 떨어지는 높이
        int v = sc.nextInt(); // 나무 막대 높이

        int day = (v - b - 1) / (a - b) + 1; // 필요한 일 수 계산

        System.out.println(day); // 결과 출력
    }
}