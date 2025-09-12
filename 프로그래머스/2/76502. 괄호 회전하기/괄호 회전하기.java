import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for (int i=0; i<s.length(); i++) {
            // 1. x만큼 회전한 문자열 구하기
            String str = rotate(s, i);
            
            // 2. 해당 문자열이 올바른 괄호 문자열인지 판단 후, 카운트   
            if (isRight(str)) {
                count++;
            }
        }
        
        
        return count;
    }
    
    public static String rotate(String s, int x) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(s.substring(x, s.length()));
        
        sb.append(s.substring(0, x));
        
        return sb.toString();
    }
    
    public boolean isRight(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c=='(' || c=='[' || c=='{') {
                stack.push(c);
            }
            else {
                // 스택이 비었거나 짝이 맞지 않으면 false
                if (stack.isEmpty() ||
                    c==')' && !(stack.pop() == '(') ||
                    c==']' && !(stack.pop() == '[') ||
                    c=='}' && !(stack.pop() == '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}