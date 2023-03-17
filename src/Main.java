package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        print(N, K);
    }

    public static void print(int N, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] answer = new int[N];
        StringBuffer sb = new StringBuffer();
        boolean out = false;

        int count = 0;

        for (int i = 1; i <= N; i++) {
            answer[i - 1] = i;
        }


        while (list.size() != N) {
            for (int i = 0; i < answer.length; i++) {
                if (!out) {
                    if (answer[i] == -1) {
                        continue;
                    }
                    count++;
                    out = count % K == 0;
                }

                if (out) {
                    if (answer[i] == -1) {
                        continue;
                    }
                    list.add(answer[i]);
                    answer[i] = -1;
                    out = false;
                }

            }
        }

        sb.append("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == answer.length - 1) {
                sb.append(list.get(i) + ">");
            } else {
                sb.append(list.get(i) + ", ");
            }
        }

        System.out.println(sb.toString());
    }
}
