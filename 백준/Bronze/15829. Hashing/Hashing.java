
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String in = br.readLine();

        String[] strArr = in.split("");

        int ans = 0;
        for (int i = 0; i < strArr.length; i++) {
            ans += (strArr[i].charAt(0) - 'a' + 1) * Math.pow(31, i);
        }

        System.out.println(ans);
    }
}