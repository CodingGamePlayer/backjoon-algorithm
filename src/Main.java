package src;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        int N = 10;
        int M = 3;
        int K = 4;
        int[] capacity = {5, 3, 4};
        System.out.println(solution(N, M, K, capacity));
    }

    private static long solution(int N, int M, int K, int[] capacity) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] remainStu = new int[M + 1];
        remainStu[0] = N;

        for (int i = 1; i <= M ; i++) {
            if (remainStu[i -1] == 0) {
                continue;
            }

            if (remainStu[i - 1] < capacity[i - 1]){
                remainStu[i] = 0;
                result.add(combination(capacity[i -1], remainStu[i -1]));
            } else {
                remainStu[i] = remainStu[i - 1] - capacity[i - 1];
                result.add(combination(remainStu[i - 1], capacity[i -1]));
            }
        }

        int teacher = 1;
        for (int i = K; i >= K - M + 1  ; i--) {
            teacher *= i;
        }
        result.add(teacher);
        return result.stream().reduce(1, (o1, o2) -> o1 * o2).intValue();
    }

    private static Integer combination(int n, int r) {
        int pResult = 1;
        for (int i = n; i >= n - r + 1 ; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= r ; i++) {
            fResult *= i;
        }

        return pResult / fResult;
    }

}




