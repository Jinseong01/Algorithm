import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수
        
        int answer = 0;
        
        // 1. 초기화
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) {
            queue.add(s);
        }
        
        // 2. 음식 섞기
        while(queue.peek() < K && queue.size()>=2) {
            int f = queue.poll();
            int s = queue.poll();
            
            queue.add(f + s*2);
            answer++;
        }
        
        return queue.peek()<K ? -1 : answer;   
    }
}