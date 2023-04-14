import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String num = sc.nextLine();

        if (len == 1) {
            System.out.println(len);
        } else {
            long sum = 0;
            num = num.replace("0", "");
            for (int i = 0; i < num.length(); i++) {
                sum += num.charAt(i) - '0';
            }

            System.out.println(sum);
        }
    }

}