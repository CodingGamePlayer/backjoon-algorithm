import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> mapName = new HashMap<>();
        Map<String, String> mapNum = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            String save = br.readLine();
            mapName.put(String.valueOf(i), save);
            mapName.put(save, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (mapName.containsKey(str)) {
                System.out.println(mapName.get(str));
            } else {
                System.out.println(mapNum.get(str));
            }
        }
    }

}