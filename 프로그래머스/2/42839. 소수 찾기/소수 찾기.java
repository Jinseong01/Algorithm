import java.util.*;

class Solution {
    
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        // 1. 탐색
        boolean[] used = new boolean[numbers.length()];
        dfs(numbers, "", used);
        
        // 2. 탐색 결과로 만들어진 숫자들 조합 중, 소수만 카운트
        return count(set);
    }
    
    private void dfs(String numbers, String current, boolean[] used) {
        // 탐색결과 set에 넣기
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i=0; i<numbers.length(); i++) {
            // 방문한 곳들은 건너뛰며 탐색
            if (used[i]) {
                continue;
            }
            
            // 방문처리 후, 이어서 탐색
            used[i] = true;
            dfs(numbers, current + numbers.charAt(i), used);
            
            // 방문처리 취소
            used[i] = false;
        }
    }
    
    private int count(Set<Integer> set) {
        int count = 0;
        
        for (int num : set) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(int n) {
        if (n<2) {
            return false;
        }
        for(int i=2; i*i<=n; i++) {
            if(n%i==0) {
                return false;
            }
        }
        
        return true;
    }
}