import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int count = 0;
        
        Map<Integer, Integer> broMap = new HashMap<>();
        Set<Integer> cheolsuSet = new HashSet<>();
        
        // 동생쪽으로 초기화
        for (int t : topping) {
            broMap.put(t, broMap.getOrDefault(t, 0) + 1);
        }
        
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            
            // 철수쪽 추가
            cheolsuSet.add(t);
            
            // 동생쪽 삭제
            broMap.put(t, broMap.get(t) - 1);
            if (broMap.get(t) == 0)  broMap.remove(t);
            
            // 확인
            if (cheolsuSet.size() == broMap.size())  count++;
        }
        
        return count;
    }
}