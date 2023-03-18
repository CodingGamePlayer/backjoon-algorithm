package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");
        int N = Integer.parseInt(arr1[0]);
        int K = Integer.parseInt(arr1[1]);
        int[] ints = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();
        solution(N, K, ints);
    }


    private static void solution(int N, int K, int[] arr2) {
        int[] minHeap = new int[N + 1];
        int count = 0;
        int limit = K;

        for (int i = 1; i < minHeap.length; i++) {

            int cur = i;
            minHeap[i] = arr2[i - 1];
            if (limit > 0){

                while (cur > 1 && minHeap[cur / 2] > minHeap[cur]) {
                    int parentValue = minHeap[cur / 2];
                    minHeap[cur / 2] = minHeap[cur];
                    minHeap[cur] = parentValue;

                    cur /= 2;
                    count++;
                    limit--;

                }
            }
        }
        if (limit < 0) {
            System.out.println(-1);
        } else {
            for (int i = 1; i < minHeap.length; i++) {
                if (i < minHeap.length - 1) {
                    System.out.print(minHeap[i] + " ");
                } else {
                    System.out.print(minHeap[i]);
                }
            }
            System.out.println();
        }
    }


}
//            if (K > 0) {
//                    int cur = i;
//                    minHeap[i] = arr2[i - 1];
//
//                    while (cur > 1 && minHeap[cur / 2] > minHeap[cur]) {
//                    int parentValue = minHeap[cur / 2];
//                    minHeap[cur / 2] = minHeap[cur];
//                    minHeap[cur] = parentValue;
//
//                    cur /= 2;
//                    count++;
//                    }
//
//                    while (true) {
//                    int leftIdx = cur * 2;
//                    int rightIdx = cur * 2 + 1;
//                    int targetIdx = -1;
//
//                    if (rightIdx < minHeap.length) {
//        targetIdx = minHeap[leftIdx] < minHeap[rightIdx] ? leftIdx : rightIdx;
//        } else if (leftIdx < minHeap.length) {
//        targetIdx = leftIdx;
//        } else {
//        break;
//        }
//
//        if (minHeap[cur] < minHeap[targetIdx]) {
//        break;
//        } else {
//        int parentValue = minHeap[cur];
//        minHeap[targetIdx] = parentValue;
//        minHeap[cur] = minHeap[targetIdx];
//        cur = targetIdx;
//        count++;
//        }
//        }
//
//        } else {
//        minHeap[i] = arr2[i - 1];
//        }