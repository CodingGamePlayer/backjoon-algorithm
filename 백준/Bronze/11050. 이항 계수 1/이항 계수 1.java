import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int p = 1;
        for (int i = n; i > n - m; i--) {
            p *= i;
        }

        int c = 1;
        for (int i = 1; i <= m ; i++) {
            c *= i;
        }

        System.out.println(p / c);
    }
}