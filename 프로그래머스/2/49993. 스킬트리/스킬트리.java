import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for(String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            
            // skillTree의 스킬이 'skill'에 있는지 확인
            for (char c : skillTree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    sb.append(c);
                }
            }
            
            if (skill.startsWith(sb.toString())) {
                count++;
            }
        }
        
        return count;
    }
}