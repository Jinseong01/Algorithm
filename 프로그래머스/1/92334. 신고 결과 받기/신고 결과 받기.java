import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 횟수 제한 X
        // 동일한 유저에 대한 신고 횟수는 1회
        // k번 이상 신고당한 유저에 기여했는지 유저별로 파악
        
        
        // 1. 유저별 신고한 ID & 유저별 신고당한 횟수
        Set<String> uniqueReport = new HashSet<>(Arrays.asList(report));
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        // 초기화
        for (String user : id_list) {
            map.put(user, new ArrayList<>());
            map2.put(user, 0);
        }
        
        // 유저별 신고 ID & 신고당한 횟수 저장
        for(String tokens : uniqueReport) {
            String[] token = tokens.split(" ");
            String user = token[0];
            String target = token[1];
            
            map.get(user).add(target);
            map2.put(target, map2.get(target)+1);
        }
        
        
        // 2. 유저별로 처리 결과 메일 횟수 파악
        int[] result = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            
            int count = 0;
            
            for (String target : map.get(user)) {
                if (map2.get(target) >= k) {
                    count++;
                }
            }
            
            result[i] = count;
        }
        
        return result;
    }
}