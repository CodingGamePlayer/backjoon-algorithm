import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        int count = 0;
        for (String s : arr) {
            if (!"".equals(s)) count++;
        }

        System.out.println(count);
    }

}