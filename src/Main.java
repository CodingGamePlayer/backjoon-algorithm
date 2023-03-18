package src;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int count = 0;
    static int LIMIT;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");
        int N = Integer.parseInt(arr1[0]);
        LIMIT = Integer.parseInt(arr1[1]);
        int[] ints = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();

        heapSort(ints);
        System.out.println(-1);
    }

    private static void heapSort(int[] ints) {
        int len = ints.length;
        buildHeap(ints, len); // 최소힙을 생성하는 메소드

        for (int i = len - 1; i >= 0; i--) {
            swap(ints, 0, i);
            heapify(ints, 0, i);
        }
    }

    private static void buildHeap(int[] ints, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(ints, i, len);
        }
    }

    private static void heapify(int[] ints, int i, int len) {
        int leftIdx = i * 2 + 1;
        int rightIdx = i * 2 + 2;
        int targetIdx = -1;

        if (rightIdx < len) {
            targetIdx = ints[leftIdx] < ints[rightIdx] ? leftIdx : rightIdx;
        } else if (leftIdx < len) {
            targetIdx = leftIdx;
        } else {
            return;
        }

        if (ints[targetIdx] < ints[i]) {
            swap(ints, i, targetIdx);
            heapify(ints, targetIdx, len);
        }
    }

    private static void swap(int[] ints, int i, int targetIdx) {
        if (count++ < LIMIT) {
            int parentVal = ints[i];
            ints[i] = ints[targetIdx];
            ints[targetIdx] = parentVal;


        }
        if (count == LIMIT + 1) {
            StringBuffer sb = new StringBuffer();
            Arrays.stream(ints).forEach(s -> sb.append(s).append(" "));
            System.out.println(sb);
            System.exit(0);
        }

    }

}
