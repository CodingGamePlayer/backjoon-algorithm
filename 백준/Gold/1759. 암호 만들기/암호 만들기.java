import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int len, n;
    static String arr[];
    static String password[];

    static String[] mothers = {"a", "e", "i", "o", "u"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        len = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new String[n];
        password = new String[len];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        dfs(0, 0);
    }

    private static void dfs(int depth, int start) {
        if (depth == len) {
            if (check()) {
                for (String s : password) {
                    System.out.print(s);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < n; i++) {
            password[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

    private static boolean check() {
        int mother = 0;
        int child = 0;
        for (int i = 0; i < password.length; i++) {
            boolean flag = false;
            for (int j = 0; j < mothers.length; j++) {
                if (mothers[j].equals(password[i])) {
                    flag = true;
                    break;
                }
            }

            if (flag) mother++;
            else child++;
        }

        if (mother >= 1 && child >= 2) return true;
        return false;
    }
}