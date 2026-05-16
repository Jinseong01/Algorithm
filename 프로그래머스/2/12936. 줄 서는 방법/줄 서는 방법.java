import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> numbers = new ArrayList<>();
        long[] factorial = new long[n+1];
        factorial[0] = 1;

        for (int i=1; i<=n; i++) {
            numbers.add(i);
            factorial[i] = factorial[i-1]*i;
        }
        
        // 0-based로 변경
        k--;
        
        int idx = 0;
        while (n>0) {
            // 남은 자리를 채우는 총 경우의 수 (1___ -> 3!)
            long caseCount = factorial[n-1];
            
            // k가 해당하는 그룹 번호
            int targetIndex = (int) (k / caseCount);
            
            // 해당 그룹에서 k의 순서
            k = k % caseCount;
            
            
            answer[idx++] = numbers.remove(targetIndex);
            n--;
        }
        
        return answer;
    }
}