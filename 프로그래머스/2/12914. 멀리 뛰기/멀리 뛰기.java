class Solution {

    private long[] memo;

    public long solution(int n) {
        memo = new long[n+1]; // current 위치별 결과 저장
        
        return dfs(0, n) % 1234567;
    }

    private long dfs(int current, int target) {
        // 도달했으면
        if (current == target) {
            return 1;
        }
        
        // 범위 벗어나면
        if (current > target) {
            return 0;
        }

        // 이미 계산한 적 있으면 바로 반환
        if (memo[current] != 0) {
            return memo[current];
        }


        // 계산 후 저장
        long count = 0;
        count += dfs(current+1, target) % 1234567;
        count += dfs(current+2, target) % 1234567;
        
        memo[current] = count;
        
        return count;
    }
}