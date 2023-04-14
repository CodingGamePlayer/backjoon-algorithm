import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Arrays.stream(arr).max().getAsInt();
        float[] fArr = new float[n];
        for (int i = 0; i < arr.length; i++) {
            fArr[i] = arr[i] / (float) max;
        }
        float sum = 0;
        for (int i = 0; i < fArr.length; i++) {
            sum += fArr[i];
        }

        System.out.println((sum / (float) n) * 100);
    }
}