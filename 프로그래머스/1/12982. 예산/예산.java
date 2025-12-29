import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 1. 오름차순 정렬
        Arrays.sort(d);
        
        // 2. 예산 확인
        int count = 0;
        for(int money : d) {
            budget -= money;
            
            if (budget < 0) {
                break;
            }
            
            count++;
        }
        
        return count;
    }
}