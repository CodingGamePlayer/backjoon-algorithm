import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] c = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            arr.add(c);
        }

        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {

                        return o1[0] - o2[0];

                }

                return o1[1] - o2[1];
            }
        });

        for (int[] a : arr) {
            for(int i : a) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}