import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int gcd = 0;
        for (int i = 1; i <= Math.max(n, m); i++) {
            if (n % i ==0 && m % i ==0) gcd = i;
        }

        System.out.println(gcd);
        System.out.println(n * m / gcd);
    }
}