import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        
        A : for (int i=0; i<=discount.length -10; i++) {
            // 각 일차에 맞게 초기화
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=i; j<i+10; j++) {
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);
            }
        
            // 확인
            for(int k=0; k<want.length; k++) {
                // 할인하지 않거나 수량이 안맞으면
                if (!map.containsKey(want[k]) || !map.get(want[k]).equals(number[k])) {
                    continue A;
                }
            }
            
            count++;
        }
        
        return count;
    }
}