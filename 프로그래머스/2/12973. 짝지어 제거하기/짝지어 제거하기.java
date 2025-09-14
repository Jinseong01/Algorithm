import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 스택의 최근 문자와 동일하다면
            if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty()? 1 : 0;
    }
}