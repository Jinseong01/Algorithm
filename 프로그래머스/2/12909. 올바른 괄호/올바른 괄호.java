import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else {
                // )의 차례에 스택이 비었으면 오류
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        // 스택이 비었으면 괄호끼리 짝지어졌다는 의미
        return stack.isEmpty();
    }
}