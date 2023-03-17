package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        print(N, K);
    }

    public static void print(int N, int K) {
        StringBuffer sb = new StringBuffer();

        LinkedList peopleList = new LinkedList();
        LinkedList result = new LinkedList();

        IntStream.range(1, N + 1).forEach(x -> peopleList.add(x));

        int cnt = 0;
        while(!peopleList.isEmpty()){
            int data = (int)peopleList.remove();
            cnt++;

            if(cnt % K == 0){
                result.add(data);
            }else {
                peopleList.add(data);
            }
        }

        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                sb.append(result.get(i) + ">");
            } else {
                sb.append(result.get(i) + ", ");
            }
        }

        System.out.println(sb.toString());
    }
}
