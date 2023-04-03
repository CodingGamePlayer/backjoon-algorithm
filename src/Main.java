package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int money = sc.nextInt();
        int answer = 0;

        int[] coins = new int[n];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = coins.length-1; i >= 0 ; i--) {
            if (money / coins[i] > 0) {
                answer += money / coins[i];
                money %= coins[i];
            }
        }

        System.out.println(answer);
    }
}

