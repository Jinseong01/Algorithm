import java.util.*;

class Solution {
    public int solution(int[] order) {
        // 1~n번 상자 순으로 받음
        // 배달 순서에 맞게 실어야 함
        // FILO 구조(=스택)의 보조 컨테이너 벨트
        // 실을 수 있는 상자의 총 개수
        
        // ex)
        // 받는 순서 : 1 ~ 5
        // 배달 순서 : 4, 3, 1, 2, 5
        
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<order.length; i++) {
            // 1. 보조 컨테이너에 곧바로 보관
            stack.push(i+1);
            
            // 2. peek하며 배달 순서와 비교
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
            }
        }
        
        return idx;
    }
}