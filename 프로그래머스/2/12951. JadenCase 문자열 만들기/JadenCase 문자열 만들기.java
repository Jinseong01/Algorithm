import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 공백 문자
            if (c == ' ') {
                sb.append(c);
                isStart = true;
            }
            // 단어 시작
            else {
                // 첫 글자
                if (isStart) {
                    sb.append(Character.toUpperCase(c));
                    isStart = false;
                }
                // 나머지 글자
                else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        return sb.toString();
    }
}