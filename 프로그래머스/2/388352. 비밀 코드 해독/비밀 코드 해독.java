import java.util.*;

class Solution {
    int[][] q;
    int[] ans;
    int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        
        dfs(1, n, new HashSet<>());
        
        return answer;
    }
    
    private void dfs(int start, int n, Set<Integer> combSet) {
        if (combSet.size() == 5) {
            for(int i=0; i<q.length; i++) {
                
                // 일치 개수 계산
                int match = 0;
                for(int qNum : q[i]) {
                    if(combSet.contains(qNum)) match++;
                }
                
                // 일치 개수 다르면 해당 시도에서 바로 종료
                if(match != ans[i]) return;
            }
            
            // 모든 시도를 충족하는 조합은 카운트 후 종료
            answer++;
            return;
        }
        
        // 남은 자리수 고려하여 조합 구성
        int remain = 5 - combSet.size();
        for(int i=start; i <= n-remain+1; i++) {
            combSet.add(i);
            dfs(i+1, n, combSet);
            
            combSet.remove(i);  // 백트래킹
        }
    }
}