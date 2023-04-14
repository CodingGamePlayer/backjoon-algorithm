import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] split = str.split("[-]");

        int answer = 0;
        for (int i = 0; i < split.length; i++) {
            String[] arr = split[i].split("[+]");

            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += Integer.parseInt(arr[j]);
            }

            if (i==0){
                answer += sum;
            } else {
                answer -= sum;
            }

        }

        System.out.println(answer);

    }
}