import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];    // 각 기능 예상 소요일

        // 1. 각 기능의 남은 작업일 계산
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            days[i] = (remain + speeds[i] - 1) / speeds[i];
        }

        // 2. 배포 순서를 계산
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int maxDay = days[0]; // 현재 배포 기준일 (첫번째 기능으로 초기화)
        int count = 1;        // 현재 배포에 포함되는 기능 수 (첫번째 기능)

        // 3. 두 번째 기능부터 마지막 기능까지 확인
        for (int i = 1; i < n; i++) {
            // 현재 기능의 예상 소요일 <= 이전 기능의 예상 소요일
            // 즉, 이전 기능과 함께 배포
            if (days[i] <= maxDay) {
                count++;
            }
            // 현재 기능의 예상 소요일 > 이전 기능의 예상 소요일
            // 현재 기능은 다음에 배포
            else {
                deque.add(count);
                count = 1;
                maxDay = days[i];
            }
        }

        // 4. 마지막 배포 단위 추가
        deque.add(count);

        // 5. int[] 변환 후 반환
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}
