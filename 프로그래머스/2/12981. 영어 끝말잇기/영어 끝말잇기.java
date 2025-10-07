import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> relay = new HashSet<>();
        
        int idx = 0;
        int round = 1;
        
        relay.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);
        
        for (int i = 1; i < words.length; i++) {
            // 1. 사이클 순환
            idx = (idx + 1) % n;
            if (idx == 0) {
                round++;
            }

            // 2. 규칙 확인
            String word = words[i];
            if (relay.contains(word) || word.charAt(0) != last) {
                return new int[]{idx + 1, round};
            }

            // 3. 갱신
            relay.add(word);
            last = word.charAt(word.length() - 1);
        }
        
        return new int[]{0, 0};
    }
}