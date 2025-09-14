import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = s.split(" ");
    
        for (String token : tokens) {
            if (token.equals("Z")) {
                stack.pop();
            }
            else {
                stack.push(Integer.parseInt(token));   
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}