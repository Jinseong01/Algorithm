import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=1; i<n; i++) {
            // 가격이 떨어졌다면
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i-j;
            }
            
            stack.push(i);
        }
        
        // 스택에 남은거 = 마지막까지 가격이 떨어지지 않은 것들
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = (n-1) - j;
        }

        return answer;
    }
}