import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < in.length(); i++) {
            int num = in.charAt(i) - 'a';
            if (arr[num] == -1) arr[num] = i;
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
