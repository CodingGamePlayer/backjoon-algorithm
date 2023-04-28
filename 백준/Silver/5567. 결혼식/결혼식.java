import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        for (int first : graph[1]) {
            if (!answer.contains(first)) answer.add(first);
            for (int second : graph[first]) {
                if (second != 1 && !answer.contains(second))answer.add(second);
            }
        }

        System.out.println(answer.size());
    }

}