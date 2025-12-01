import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // H-Index : h번 이상 인용된 논문이 h편 이상
        // H-Index 최댓값은 논문 개수(N)
        
        // 1. 오름차순 정렬 10 10 10 10
        Arrays.sort(citations);

        // 2. N부터 1까지 순서대로 조건 확인
        // N번 이상 인용된 논문이 N편 이상, ...
        for (int i = 0; i < citations.length; i++) {
            // 확인할 대상값  ex. 4
            int h = citations.length-i;
            
            // 논문 h편의 최소 인용횟수  ex. 10
            int minCitation = citations[i];
            
            // minCitation이 h 이상이면 → 해당 논문들은 모두 h회 이상
            if (minCitation >= h) {
                return h;
            }
        }
        
        // N~1 조건 충족 X
        return 0;
    }
}