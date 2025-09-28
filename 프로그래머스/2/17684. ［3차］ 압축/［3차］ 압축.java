import java.util.*;

class Solution {
    HashMap<String, Integer> dict = new HashMap<>();
    
    public int[] solution(String msg) {
        // 1. 초기화
        for (int i=0; i<26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i+1);
        }
        
        // 2. 가장 긴 문자열 & 다음 문자열 사전 검색/등록
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0;
        while (i < msg.length()) {
            // 가장 긴 문자열 출력
            String first = find(msg, i);
            answer.add(dict.get(first));

            // 다음 문자열 사전 검색 & 등록
            int firstLen = first.length();
            int nextPos = i + firstLen;
            
            if (nextPos < msg.length()) {
                String second = first + msg.charAt(nextPos);
                dict.put(second, dict.size()+1);
            }

            i += firstLen;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private String find(String msg, int start) {
        int end = msg.length();
        while(end > start) {
            String now = msg.substring(start, end);
            if(dict.containsKey(now)) {
                return now;
            }
            end--;
        }
        
        return "";
    } 
}