import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        // 아직 뒷 큰수를 못 찾은 인덱스를 저장
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            // numbers[i]가 이전 원소들의 뒷 큰수가 될 수 있는지 확인
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            
            // 현재 인덱스는 아직 뒷 큰수를 모름
            stack.push(i);
        }
        
        return answer;
    }
}