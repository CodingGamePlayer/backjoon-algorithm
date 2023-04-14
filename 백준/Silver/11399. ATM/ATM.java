import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        int answer = list.get(0);
        int cur = answer;
        for (int i = 1; i < list.size(); i++) {
            cur = cur + list.get(i);
            answer += cur;
        }
        System.out.println(answer);
    }
}