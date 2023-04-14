import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder();

            String[] str = sc.nextLine().split(" ");
            int time = Integer.parseInt(str[0]);
            for (int j = 0; j < str[1].length(); j++) {
                for (int k = 0; k < time; k++) {
                    sb.append(str[1].charAt(j));
                }
            }

            System.out.println(sb.toString());
        }
    }

}