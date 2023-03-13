package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (check(a, arr)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean check(int a, int[] arr) {

        ArrayList<Stack> arrayList = new ArrayList<>(Arrays.asList(
                new Stack<>(),
                new Stack<>(),
                new Stack<>(),
                new Stack<>()
        ));


        for (int i = 0; i < a; i++) {
            int point = 1;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).isEmpty()) {
                    arrayList.get(j).push(arr[i]);
                    break;
                }
                int peek = (int) arrayList.get(j).peek();
                if (peek > arr[i]) {
                    if (point >= arrayList.size()) {
                        return false;
                    }
                    point++;
                } else {
                    arrayList.get(j).push(arr[i]);
                    break;
                }
            }
        }

        return true;
    }
}
