import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int[] arr = new int[3];

            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();

            if (arr[0] == 0 && arr[1] == 0 && arr[1] == 0) break;

            Arrays.sort(arr);
            
            double pow = Math.pow(arr[2], 2);
            double pow1 = Math.pow(arr[1], 2);
            double pow2 = Math.pow(arr[0], 2);
            if (pow == pow1 + pow2) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}