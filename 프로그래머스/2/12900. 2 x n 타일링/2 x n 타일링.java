class Solution {
    public int solution(int n) {
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // 4 -> 5
        // 5 -> 8 (1x5 / 1x3 + 2 / 1 + 2x2)
        int[] dp = new int[n+1];  // dp[n]은 가로 길이가 n인 2×n 바닥을 채우는 방법의 수
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
        }
        
        return dp[n];
    }
}