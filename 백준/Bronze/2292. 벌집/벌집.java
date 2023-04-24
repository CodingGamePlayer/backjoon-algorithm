
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 1;
        int house = 1;
        int jump = 6;
        while (!(n <= house)){
            cnt++;
            house += jump;
            jump += 6;
        }
        System.out.println(cnt);
    }
}