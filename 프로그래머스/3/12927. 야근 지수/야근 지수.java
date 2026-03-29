import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // N시간 동안 야근 피로도를 최소화
        // 야근 피로도 : 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
        // 1시간 동안 작업량 1만큼을 처리
        
        // 1. 작업량이 많은 것부터 n을 사용하며 차감
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            pq.add(work);
        }

        while(n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if(max == 0) {
                break;
            }
            
            pq.add(max-1);
            n--;
        }
        
        // 2. 야근 피로도 구하기
        long answer = 0;
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }
            
        return answer;
    }
}