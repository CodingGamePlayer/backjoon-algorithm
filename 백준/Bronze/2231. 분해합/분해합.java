
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n > 0) {

            boolean isContain = false;
            for (int i = 1; i < n; i++) {
                String[] split = String.valueOf(i).split("");
                int sum = i;

                for (String num : split) {
                    sum += Integer.parseInt(num);
                }

                if (sum == n) {
                    isContain = true;
                    System.out.println(i);
                    break;
                }
            }

            if (!isContain) {
                System.out.println(0);
            }

        } else {
            System.out.println(0);
        }

    }
}