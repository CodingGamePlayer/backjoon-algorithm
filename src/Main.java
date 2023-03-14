package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int[] arrA = Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(check(arrA, arrB));
    }

    public static int check(int[] arrA, int[] arrB) {
        int count = 0;
        int target;
        LinkedList<Integer> deque = new LinkedList<>();
        int[] arrFind = arrB.clone();

        for (int i = 1; i <= arrA[0]; i++) {
            deque.offer(i);
        }


        for (int i = 0; i < arrFind.length; i++) {
            target = deque.indexOf(arrFind[i]);
            int half = deque.size() / 2;
            if (target <= half) {
                while (target != 0) {
                    deque.offerLast(deque.pollFirst());
                    target--;
                    count++;
                }
            } else {
                while (target != deque.size()) {
                    deque.offerFirst(deque.pollLast());
                    target++;
                    count++;
                }
            }
            deque.pollFirst();
        }


        return count;
    }
}
