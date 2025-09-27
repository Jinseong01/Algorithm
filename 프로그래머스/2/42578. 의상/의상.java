import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 최소 1개 이상의 카테고리별 의상으로 구성된 조합 총 개수
        
        // 1. {카테고리 : 옷 이름}
        HashMap<String, List<String>> closet = new HashMap<>();
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String category = cloth[1];
            
            closet.putIfAbsent(category, new ArrayList<>());
            closet.get(category).add(name);
        }
        
        // 2. 조합 개수 구하기
        // '코니는 하루에 최소 한 개의 의상은 입습니다.'
        // -> 카테고리별로 의상을 선택하지 않는거까지 +1하여 모든 경우의 수를 구함
        //    마지막에 아무것도 입지 않는 경우 -1해줌
        int answer = 1;
        for(String category : closet.keySet()) {
            answer *= closet.get(category).size()+1;
        }
        
        return answer-1;
    }
}