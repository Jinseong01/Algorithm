import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][];
        for(int i=0; i<n; i++) {
            dp[i] = new int[i+1];
        }
        
        // dp[i][j]는 i번째 라인의 j번째 숫자까지의 최댓값
        dp[0][0] = triangle[0][0];
        
        // 7
        // 38
        // 810
        // 2744
        // 45265
        for(int i=1; i<n; i++) {
            for(int j=0; j<i+1; j++) {
                if (j==0) { // 왼쪽 대각선
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }
                else if (j==i) { // 오른쪽 대각선
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                else { // 왼쪽 or 오른쪽 대각선 중 최댓값
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        
        return Arrays.stream(dp[n - 1]).max().getAsInt();
    }
}