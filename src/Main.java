package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String paragraph = sc.nextLine();
            if ("0".equals(paragraph)) break;
            list.add(paragraph);
        }

        String WHO = sc.nextLine();
        String WHERE = sc.nextLine();
        String WHAT = sc.nextLine();

        solution(list, WHO, WHERE, WHAT);
    }

    public static void solution(ArrayList<String> list, String WHO, String WHERE, String WHAT) {
        int count = 0;

        while (list.size() != count) {
            String now = list.get(count);

            if (now.contains("WHO")) {
                now = now.replaceAll("WHO", WHO);
            }
            if (now.contains("WHERE")) {
                switch (WHERE) {
                    case "WHO":
                        now = now.replaceAll("WHERE", WHO);
                        break;
                    default:
                        now = now.replaceAll("WHERE", WHERE);
                }
            }
            if (now.contains("WHAT")) {
                switch (WHAT) {
                    case "WHERE":
                        switch (WHERE) {
                            case "WHO" :
                                now = now.replaceAll("WHAT", WHO);
                                break;
                            default:
                                now = now.replaceAll("WHAT", WHERE);
                        }
                        break;
                    case "WHO":
                        now = now.replaceAll("WHAT", WHO);
                        break;
                    default:
                        now = now.replaceAll("WHAT", WHAT);
                }
            }


            System.out.println(now);
            count++;
        }

    }


}
