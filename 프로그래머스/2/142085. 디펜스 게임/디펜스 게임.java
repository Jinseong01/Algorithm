import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            
            // 이전 라운드 중에서 무적권을 사용해야 했음을 의미
            if(n<0) {
                // 무적권을 전부 사용함
                if(k==0) {
                    return i;
                }
                
                // 이전 라운드 중 병사가 가장 많았던 라운드를 무적권 사용한 것으로 처리
                n += pq.poll();
                k--;
            }
        }
        
        return enemy.length;
    }
}