import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] target = new int[m];

        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : target) {
            if (map.containsKey(num)) {
                sb.append(map.get(num) + " ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString());
    }
}