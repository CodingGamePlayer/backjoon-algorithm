import java.util.*;

public class Main {
    static List<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        List<Integer> friends = new ArrayList<>();
        for(int friend : graph[1]){
            if (!friends.contains(friend)) friends.add(friend);

            for (int friendOfFriend : graph[friend]) {
                if (friendOfFriend != 1 && !friends.contains(friendOfFriend)){
                    friends.add(friendOfFriend);
                }
            }
        }

        System.out.println(friends.size());

    }

}
