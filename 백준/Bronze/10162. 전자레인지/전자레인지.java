import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();

        int[] sec = {300, 60, 10};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(s / sec[i] + " ");
            s %= sec[i];
        }

        if (s != 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }
}