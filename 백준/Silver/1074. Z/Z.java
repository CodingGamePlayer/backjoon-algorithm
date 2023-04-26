import java.util.Scanner;

public class Main {
    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        sc.close();

        int size = (int) Math.pow(2, N);
        divide(0, 0, size);
    }

    static void divide(int x, int y, int size) {
        if (size == 1) {
            if (x == r && y == c) {
                System.out.println(count);
            }
            count++;
            return;
        }

        int half = size / 2;
        int area = half * half;

        if (r < x + half && c < y + half) {
            divide(x, y, half);
        } else if (r < x + half && c >= y + half) {
            count += area;
            divide(x, y + half, half);
        } else if (r >= x + half && c < y + half) {
            count += area * 2;
            divide(x + half, y, half);
        } else {
            count += area * 3;
            divide(x + half, y + half, half);
        }
    }
}