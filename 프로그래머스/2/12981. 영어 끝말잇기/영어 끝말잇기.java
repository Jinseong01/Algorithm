import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> relay = new HashSet<>();

        relay.add(words[0]);
        char last = words[0].charAt(words[0].length()-1);
        
        for (int i = 1; i < words.length; i++) {
            // 1. 규칙 확인
            String word = words[i];
            if (relay.contains(word) || word.charAt(0) != last) {
                int idx = (i % n) + 1;
                int round = (i / n) + 1;
                return new int[]{idx, round};
            }

            // 2. 갱신
            relay.add(word);
            last = word.charAt(word.length() - 1);
        }
        
        return new int[]{0, 0};
    }
}