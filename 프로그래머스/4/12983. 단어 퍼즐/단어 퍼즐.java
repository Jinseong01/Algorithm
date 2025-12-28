import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
    
    
        // dp[i] = t의 [0번째 ~ i-1번째]까지 만드는데 필요한 최소 문자열 개수
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        
        for (int i = 0; i < n; i++) {
            // 현재 위치까지 만들 수 없으면 스킵
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (String s : strs) {
                int len = s.length();
                
                // t 문자열의 i번째 위치부터 s 문자열로 시작하는지 여부
                // 범위를 벗어나지 않는지 & i번째부터 s로 시작하는지
                if (i + len <= n && t.startsWith(s, i)) {
                    // 기존꺼 vs dp[i]에다가 문자열 1개 추가한 거
                    // => 더 적은 개수 선택
                    dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
