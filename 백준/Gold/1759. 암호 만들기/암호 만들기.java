import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] answer, arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = new char[L];
        arr = new char[C];
        visited = new boolean[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        find(0, bw, 0);

        bw.flush();
    }

    private static void find(int depth, BufferedWriter bw, int start) throws IOException {
        if (depth == L) {
            if (isPossible()) {
                for (char c : answer) {
                    bw.write(c);
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            answer[depth] = arr[i];
            find(depth + 1, bw, i + 1);
        }


    }

    private static boolean isPossible() {
        char[] mothers = {'a', 'e', 'i', 'o', 'u'};
        int m = 0;
        int c = 0;

        for (int i = 0; i < answer.length; i++) {
            boolean isMother = false;
            for (int j = 0; j < mothers.length; j++) {
                if (answer[i] == mothers[j]) {
                    isMother = true;
                    break;
                }
            }

            if (isMother) m++;
            else c++;
        }

        if (m >= 1 && c >= 2) return true;

        return false;
    }
}