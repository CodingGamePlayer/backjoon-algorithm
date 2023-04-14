import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());


        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            String[] split = str.split("X{1,}");
            int sum = 0;

            for (int j = 0; j < split.length; j++) {
                for (int k = 1; k <= split[j].length(); k++) {
                    sum += k;
                }
            }

            System.out.println(sum);
        }
    }

}