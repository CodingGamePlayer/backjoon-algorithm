package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        solution(arr1, arr2, n);

    }

    private static void solution(int[] arr1, int[] arr2, int n) {
        LinkedList<Integer> listA = new LinkedList<>(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
        LinkedList<Integer> listB = new LinkedList<>(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
        Collections.sort(listA);
        Collections.sort(listB, Collections.reverseOrder());

        int sum = 0;
        while (n > 0){
            int a = listA.poll();
            int b = listB.poll();

            sum += a * b;

        }

        System.out.println(sum);
    }
}




