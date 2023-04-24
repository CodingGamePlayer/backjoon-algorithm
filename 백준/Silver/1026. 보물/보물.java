import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr1.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            arr2.add(sc.nextInt());
        }

        Collections.sort(arr1);
        Collections.sort(arr2, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < arr1.size(); i++) {
            sum += arr1.get(i) * arr2.get(i);
        }

        System.out.println(sum);
    }
}