import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int shortX = Math.min(Math.abs(w - x), x);
        int shortY = Math.min(Math.abs(y - h), y);

        System.out.println(Math.min(shortX, shortY));
    }
}
