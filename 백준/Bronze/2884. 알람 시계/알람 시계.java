import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();

        if (hour == 0) hour = 24;
        int originMin = min + (hour * 60);
        int alarmMin = originMin - 45;

        int afterHour = alarmMin / 60;
        int afterMin = alarmMin % 60;
        if (afterHour == 24) afterHour = 0;
        System.out.println(afterHour + " " + afterMin);
    }

}
