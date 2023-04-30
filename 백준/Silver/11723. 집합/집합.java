import java.io.*;
import java.util.*;

public class Main {
    static int[] set = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                add(num);
            } else if (command.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                remove(num);
            } else if (command.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                bw.write(check(num) + "\n");
            } else if (command.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                toggle(num);
            } else if (command.equals("all")) {
                all();
            } else if (command.equals("empty")) {
                empty();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void add(int num) {
        set[num] = 1;
    }

    private static void remove(int num) {
        set[num] = 0;
    }

    private static int check(int num) {
        return set[num];
    }

    private static void toggle(int num) {
        set[num] = set[num] == 1 ? 0 : 1;
    }

    private static void all() {
        Arrays.fill(set, 1);
    }

    private static void empty() {
        Arrays.fill(set, 0);
    }
}
