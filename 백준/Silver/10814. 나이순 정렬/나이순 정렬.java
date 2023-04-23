import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String>[] list = new List[201];

        for (int i = 0; i < 201; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            String name = s[1];

            list[age].add(name);
        }

        for (int i = 0; i < 201; i++) {
            if (list[i] != null) {
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.printf("%d %s \n", i, list[i].get(j));
                }
            }
        }
    }
}