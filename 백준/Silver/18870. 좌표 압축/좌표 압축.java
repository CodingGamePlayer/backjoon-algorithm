
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        int[] ans = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Integer n = Integer.valueOf(st.nextToken());
            ans[i] = n;
            set.add(n);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), idx++);
        }

        for (int i = 0; i < N; i++) {
            ans[i] = map.get(ans[i]);
        }

        for (int a : ans) {
            bw.write(a + " ");
        }
        bw.flush();
    }
}