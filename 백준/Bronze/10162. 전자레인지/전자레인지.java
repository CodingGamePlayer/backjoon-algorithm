import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 10 != 0) {
            System.out.println(-1);
        } else {
            int[] arr = {300, 60, 10};

            int[] ans = new int[3];
            for (int i = 0; i < arr.length; i++) {
                if (n / arr[i] > 0) {
                    ans[i] = n / arr[i];
                    n %= arr[i];
                }
                System.out.print(ans[i] + " ");
            }
        }
    }
}