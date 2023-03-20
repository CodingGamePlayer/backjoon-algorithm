package src;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();
        sc.nextLine();

        solution(s, target);

    }

    private static void solution(int[] s, int target) {

        Hashtable<Integer, Integer> map = new Hashtable<>();

        for (int i : s) {
            int num = (int) map.getOrDefault(i, 0);
            map.put(i, ++num);
        }

        if (map.get(target) != null)
            System.out.println(map.get(target));
        else
            System.out.println(0);
    }


}
