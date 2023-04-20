import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        Arrays.sort(list);

        for (int i = 0; i < target.length; i++) {
            int idx = Arrays.binarySearch(list, target[i]);
            if (idx >= 0) System.out.println(1);
            else System.out.println(0);
        }
    }

}