package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] splitA = s.split("[-]");

        int ans = 0;
        for (int i = 0; i < splitA.length; i++) {
            String[] splitB = splitA[i].split("[+]");

            int sum = 0;
            for (int j = 0; j < splitB.length; j++) {
                sum += Integer.parseInt(splitB[j]);
            }

            if (i == 0) {
                ans = sum;
            } else {
                ans -= sum;
            }
        }

        System.out.println(ans);
    }
}




