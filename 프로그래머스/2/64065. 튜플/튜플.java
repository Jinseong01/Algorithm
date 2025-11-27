import java.util.*;

class Solution {
    public int[] solution(String s) {
        String parsed1 = s.substring(2, s.length()-2);
        // "1,2,3},{2,1},{1,2,4,3},{2"
        
        String[] parsed2 = parsed1.split("\\},\\{");
        // "1,2,3", "2,1", "1,2,4,3", "2"
        
        Arrays.sort(parsed2, (a,b) -> a.length()-b.length());
        // "2", "2,1", "1,2,3", "1,2,4,3"

        HashSet<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for(String str : parsed2) {
            String[] parsed3 = str.split(",");
            
            for(String num : parsed3) {
                int n = Integer.parseInt(num);
                if(!set.contains(n)) {
                    set.add(n);
                    answer.add(n);
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}