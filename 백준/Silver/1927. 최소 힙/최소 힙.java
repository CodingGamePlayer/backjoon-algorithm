import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> heap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            Long in = Long.valueOf(br.readLine());

            if (in == 0) {
                if (heap.size() == 0) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.offer(in);
            }
        }
    }

}
