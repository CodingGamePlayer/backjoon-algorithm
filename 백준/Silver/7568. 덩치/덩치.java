import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] people = new int[n][2];

        for (int i = 0; i < n; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
        }

        int[] ranks = new int[n];

        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]){
                    rank++;
                }
            }

            ranks[i] = rank;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ranks[i] + " ");
        }
    }
}