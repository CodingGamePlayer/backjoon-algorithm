package src;


public class Main {
    static int[][] arr;
    static int num = 1;

    static int targetI;
    static int targetJ;


    public static int solution(int N, int i, int j) {
        arr = new int[N][N];
        targetI = i;
        targetJ = j;
        dac(0, 0, N);

        return arr[i][j];
    }

    private static void dac(int row, int col, int size) {
        if (size == 1) {
            arr[row][col] = num++;
            return;
        }

        int n = size / 2;
        dac(row, col + n, n);
        if (arr[targetI][targetJ] != 0) return;
        dac(row, col, n);
        if (arr[targetI][targetJ] != 0) return;
        dac(row + n, col, n);
        if (arr[targetI][targetJ] != 0) return;
        dac(row + n, col + n, n);
    }


    public static void main(String[] args) {
        int n = 4;
        int i = 1;
        int j = 3;
        System.out.println(solution(n, i, j));
    }

}




