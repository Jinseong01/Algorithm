import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1. priorities 순서대로 큐 초기화
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int p : priorities) {
            deque.add(p);
        }

        
        // 2. 우선순위 고려한 실제 실행순서에서의 priorities[location] 순서
        // priorities에서의 순서와 실제 실행순서는 다르므로,
        // priorities[location]의 위치 기록 필요
        int count = 0;  // 프로세스 누적 실행개수
        while (!deque.isEmpty()) {
            int current = deque.poll();
            int max = deque.isEmpty() ? current : Collections.max(deque);   // 큐 안 최대 우선순위

            // 큐에 더 높은 우선순위 O -> 실행하지 않고 순서 밀림
            if (current < max) {
                deque.add(current);

                // 방금 추가한거 = 추적하던거
                if (location == 0) {
                    location = deque.size() - 1;
                }
                // 방금 추가한거 != 추적하던거
                else {
                    location--;
                }
            }
            
            // 큐에 더 높은 우선순위 X -> 바로 실행
            else {
                count++;    // 1개 실행
                // 방금 실행한거 = 추적하던거
                if (location == 0) {
                    return count;
                }
                // 방금 실행한거 != 추적하던거
                else {
                    location--;
                }
            }
        }

        return count;
    }
}