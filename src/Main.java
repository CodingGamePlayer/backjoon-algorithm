package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        int count = Integer.parseInt(sc.nextLine());

        while (count > 0) {
            String now = sc.next();
            sc.nextLine();
            list.add(now);
            count--;
        }

        solution(list);

    }

    private static void solution(ArrayList<String> list) {
        Stack stack = new Stack();
        int count = 0;

        while (list.size() > count) {
            stack.clear();

            boolean flag = false;
            String s = list.get(count);
            String[] split = s.split("");

            for (String str : split) {

                if ("(".equals(str)) {
                    stack.add("(");
                } else {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }

            }

            if (!flag && stack.isEmpty()){
                System.out.println("YES");
            } else {
                System.out.println("NO");

            }
            count++;
        }


    }


}
