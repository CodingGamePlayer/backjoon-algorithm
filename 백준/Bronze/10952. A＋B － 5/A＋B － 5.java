import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int i = sc.nextInt() + sc.nextInt();
            if (i == 0){
                break;
            }
            System.out.println(i);
        }
    }

}