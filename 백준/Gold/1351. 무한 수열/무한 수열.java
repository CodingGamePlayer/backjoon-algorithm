import java.util.*;

public class Main {
    static HashMap<Long, Long> memo = new HashMap<Long, Long>();
    static long P;
    static long Q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();

        long result = solve(N);
        System.out.println(result);
    }

    public static long solve(long num) {
        if (num == 0) return 1;
        if (memo.containsKey(num)) return memo.get(num);

        memo.put(num, solve(num / P) + solve(num / Q));

        return memo.get(num);
    }
}