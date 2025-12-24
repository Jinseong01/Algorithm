class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        
        // 물에 잠긴 지역
        for (int[] puddle : puddles) {
            int x = puddle[0]-1;
            int y = puddle[1]-1;
            dp[x][y] = -1;
        }
        
        // 집 위치
        dp[0][0] = 1;
        
        // 나머지 좌표들 가는 가짓수
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                // 물에 잠긴 지역
                if (dp[i][j] == -1) { 
                    dp[i][j] = 0;
                }
                // 나머지 지역
                else {
                    if (i > 0) {
                        dp[i][j] = dp[i][j] + dp[i-1][j];  // 위에서 오는 경로
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j] + dp[i][j-1]; // 왼쪽에서 오는 경로
                    }
                }
                
                dp[i][j] %= 1_000_000_007;
            }
        }
        
        return dp[m-1][n-1];
    }
}