import java.util.*;

class Solution {
    public int solution(String s) {
        // 1. 괄호끼리 짝을 미리 매칭
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        // 2. 
        int n = s.length();
        s += s;
        int answer = 0;
        
        // 3.[0 ~ n-1]만큼 회전
        // '회전'을 구현하지 않고 문자열 이어붙이고 1칸씩 뒤로 밀면서 판단
        A : for (int i=0; i<n; i++) {
            Stack<Character> stack = new Stack<>();
            
            // 배열의 인덱스 (점차 뒤로 1칸씩 밀릴 예정)
            for (int j=i; j<i+n; j++) {
                char c = s.charAt(j);
                
                // map에 없는 키는 열린괄호이므로 스택에 넣음
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                
                else {
                    // 닫힌 괄호 차례에 스택이 비었거나,
                    // 괄호 종류가 매칭되지 않으면 잘못된 괄호 구성
                    if (stack.isEmpty() ||
                        !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            
            // 스택이 비었어야 제대로 끝난것임
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}