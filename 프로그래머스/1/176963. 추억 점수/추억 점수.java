import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 각 사진별 인물들의 그리움 점수 총합
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            for(String person : photo[i]) {
                answer[i] += map.getOrDefault(person, 0);
            }
        }
        
        return answer;
    }
}