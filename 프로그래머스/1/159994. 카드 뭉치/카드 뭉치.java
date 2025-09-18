import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 1. 큐 초기화
        ArrayDeque<String> cards1_queue = new ArrayDeque<>(Arrays.asList(cards1));    
        ArrayDeque<String> cards2_queue = new ArrayDeque<>(Arrays.asList(cards2));
        
        // 2. 가능한지 확인
        for(String s : goal) {
            if (!cards1_queue.isEmpty() && s.equals(cards1_queue.peek())) {
                cards1_queue.poll();
            }
            else if (!cards2_queue.isEmpty() && s.equals(cards2_queue.peek())) {
                cards2_queue.poll();
            }
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}