class Solution {
    
    private static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int index, int sum) {
        // 탐색 종료
        if (index == numbers.length) {
            // target값이 나왔으면 카운트
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        // +인 경우
        dfs(numbers, target, index+1, sum+numbers[index]);
        
        // -인 경우
        dfs(numbers, target, index+1, sum-numbers[index]);
    }
}