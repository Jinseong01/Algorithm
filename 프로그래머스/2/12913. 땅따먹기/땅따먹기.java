import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][];
        for(int i=0; i<n; i++) {
            dp[i] = new int[4];
        }
        
        // dp[i][j]는 i,j 칸까지의 최댓값
        
        for(int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++) {
            // i,j에서의 최댓값 구하기
            for(int j=0; j<4; j++) {
                
                // 이전행 & 다른열의 최댓값 구하기
                int max = 0;
                for(int k=0; k<4; k++) {
                    if(k!=j) {
                        max = Math.max(max, dp[i-1][k]);
                    }
                }
                
                // i,j칸의 점수 + max
                dp[i][j] = land[i][j] + max; 
            }
        }

        return Arrays.stream(dp[n-1]).max().getAsInt();
    }
}