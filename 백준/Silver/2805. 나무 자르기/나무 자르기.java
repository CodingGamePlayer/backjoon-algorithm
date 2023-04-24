import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 나무의 수
        int m = sc.nextInt(); // 가져가려는 나무의 길이

        int[] trees = new int[n]; // 나무의 높이를 저장할 배열

        // 나무의 높이 입력받기
        for (int i = 0; i < n; i++) {
            trees[i] = sc.nextInt();
        }

        // 이분 탐색을 위한 시작과 끝 값 설정
        int left = 0;
        int right = Arrays.stream(trees).max().getAsInt();

        int result = 0; // 최종 결과값을 저장할 변수

        // 이분 탐색
        while (left <= right) {
            int mid = (left + right) / 2; // 중간 높이 계산

            long sum = 0; // 가져갈 나무의 길이를 저장할 변수

            // 각 나무에서 가져갈 길이 계산하여 sum에 더하기
            for (int tree : trees) {
                sum += Math.max(tree - mid, 0);
            }

            // 가져갈 나무의 길이가 m 이상인 경우
            if (sum >= m) {
                result = mid; // 현재 높이를 결과값으로 저장
                left = mid + 1; // 높이를 높여서 가능한 최대 높이를 찾기
            } else { // 가져갈 나무의 길이가 m 미만인 경우
                right = mid - 1; // 높이를 낮춰서 가져갈 나무의 길이를 늘릴 수 있도록 함
            }
        }

        System.out.println(result); // 결과값 출력
    }
}
