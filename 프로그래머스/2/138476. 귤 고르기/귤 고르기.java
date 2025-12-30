import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. Map에 정리
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // 2. 내림차순 개수 추출
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        // 3. 고르기
        int sum = 0;
        int answer = 0;

        for (int c : counts) {
            sum += c;
            answer++;
            if (sum >= k) {
                break;
            }
        }

        return answer;
    } 
}