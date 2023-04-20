
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int minCount = n * m;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                char[][] chess = new char[8][8];

                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        chess[x - i][y - j] = board[x][y];
                    }
                }

                int count = getMinCount(chess);
                if (count < minCount){
                    minCount = count;
                }
            }
        }

        System.out.println(minCount);

    }

    private static int getMinCount(char[][] chess) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0){
                    if (chess[i][j] == 'W') count1++;
                    else count2++;
                } else {
                    if (chess[i][j] == 'B') count1++;
                    else count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}
