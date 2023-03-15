package src;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int arrA = Integer.parseInt(s1);
        int[] arrB = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Arrays.stream(arrB).min().orElse(0);
        int max = Arrays.stream(arrB).max().orElse(0);
        System.out.printf("%d %d", min, max);
    }

//    public static int[] check(int arrA, int[] arrB) {
//
//        return new int[] {min,max};
//    }
}
