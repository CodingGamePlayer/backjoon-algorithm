import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Set<String> set = new HashSet<>();
        List<String>[] list = new ArrayList[51];

        for (int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }

        for (int i = 0; i < 51; i++) {
            list[i] = new ArrayList<>();
        }

        Iterator<String> str = set.iterator();

        while (str.hasNext()) {
            String next = str.next();
            int len = next.length();

            list[len].add(next);
            Collections.sort(list[len]);
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i].isEmpty()) continue;

            Iterator<String> iterator = list[i].iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }


    }
}