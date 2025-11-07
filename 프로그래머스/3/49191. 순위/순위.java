class Solution {
    public int solution(int n, int[][] results) {
        // [4,3] [3,2] -> [4,2] 과정을 거쳐서
        // 이기거나 진사람의 합이 (n-1)명이라면 순위 확정 가능
        
        boolean[][] win = new boolean[n+1][n+1];
        
        for(int[] result : results) {
            win[result[0]][result[1]] = true;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            int count = 0;
            for(int j=1; j<=n; j++) {
                if (i==j) continue;
                if (win[i][j] || win[j][i]) count++;
            }
            
            if (count == n-1) answer++;
        }
        
        return answer;
    }
}