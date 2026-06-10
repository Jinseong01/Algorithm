import java.util.*;

class Solution {

    public int solution(int[] picks, String[] minerals) {
        // "캐기 어려운 광물이 많은 그룹에 좋은 곡괭이를 우선 사용"
        
        int totalPick = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPick*5);
        List<int[]> groups = new ArrayList<>();  // 각 그룹별 [난이도, 다이아 개수, 철 개수, 돌 개수]
        
        // 1. 광물을 5개 단위로 그룹화하고 난이도 계산
        for(int i=0; i<maxMinerals; i+=5) {
            int score = 0;
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j=i; j<i+5 && j<maxMinerals; j++) {
                if(minerals[j].equals("diamond")) {
                    diamond++;
                    score += 25;
                }
                else if(minerals[j].equals("iron")) {
                    iron++;
                    score += 5;
                }
                else {
                    stone++;
                    score += 1;
                }
            }
            
            groups.add(new int[] {score, diamond, iron, stone});
        }
    

        // 2. 난이도가 높은 그룹부터 정렬
        groups.sort((a, b) -> b[0] - a[0]);
        
        
        // 3. 좋은 곡괭이부터 순서대로 배정
        int answer = 0;
        for(int[] group : groups) {
            int diamond = group[1];
            int iron = group[2];
            int stone = group[3];
            
            if(picks[0]>0) {
                picks[0]--;
                answer += diamond + iron + stone;
            }
            else if (picks[1]>0) {
                picks[1]--;
                answer += diamond*5 + iron + stone;
            }
            else {
                picks[2]--;
                answer += diamond*25 + iron*5 + stone;
            }
        }

        return answer;
    }
}