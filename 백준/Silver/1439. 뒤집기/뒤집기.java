import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] split1 = s.split("0{1,}");
        String[] split2 = s.split("1{1,}");

        int one = 0;
        int zero = 0;
        for (int i = 0; i < split1.length; i++) {
            if (split1[i].contains("1")) one++;
        }

        for (int i = 0; i < split2.length; i++) {
            if (split2[i].contains("0")) zero++;
        }

        System.out.println(Math.min(one, zero));
    }
}
