import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arrA = new ArrayList<>();
        ArrayList<Integer> arrB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrA.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            arrB.add(sc.nextInt());
        }

        Collections.sort(arrA);
        Collections.sort(arrB,Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += arrA.get(i) * arrB.get(i);
        }

        System.out.println(answer);
    }
}